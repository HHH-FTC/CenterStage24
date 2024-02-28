package org.firstinspires.ftc.teamcode.control.vision

import android.graphics.Canvas
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration
import org.firstinspires.ftc.vision.VisionProcessor
import org.opencv.core.Core
import org.opencv.core.Mat
import org.opencv.core.Point
import org.opencv.core.Rect
import org.opencv.core.Scalar
import org.opencv.imgproc.Imgproc

class RedCvProcessor : VisionProcessor {
    //red right and blue right
    private var leftRect: Rect? = null
    private var middleRect: Rect? = null
    private var hsvMat = Mat()
    private var lowMat = Mat()
    private var highMat = Mat()
    private var detectedMat = Mat()
    private var detectingRed = true
    private var leftThreshold = 0.1
    private var middleThreshold = 0.1
    private var previousSpikeMark: SpikeMark? = null
    var mark = SpikeMark.UNFOUND
        private set

    override fun init(width: Int, height: Int, calibration: CameraCalibration) {
        leftRect = Rect(
            Point(0.0, 0.25 * height),
            Point(0.45 * width, height.toDouble())
        )
        middleRect = Rect(
            Point(0.45 * width, 0.25 * height),
            Point(0.7 * width, height.toDouble())
        )
    }

    override fun processFrame(frame: Mat, captureTimeNanos: Long): Any {
        Imgproc.cvtColor(frame, hsvMat, Imgproc.COLOR_RGB2HSV)
        val lowerRedThresholdLow = Scalar(0.0, 125.0, 125.0)
        val lowerRedThresholdHigh = Scalar(10.0, 255.0, 255.0)
        val upperRedThresholdLow = Scalar(165.0, 125.0, 125.0)
        val upperRedThresholdHigh = Scalar(180.0, 255.0, 255.0)

        Core.inRange(hsvMat, lowerRedThresholdLow, lowerRedThresholdHigh, lowMat)
        Core.inRange(hsvMat, upperRedThresholdLow, upperRedThresholdHigh, highMat)
        Core.bitwise_or(lowMat, highMat, detectedMat)

        val leftPercent =
            Core.sumElems(detectedMat.submat(leftRect)).`val`[0] / 255 / leftRect!!.area()
        val middlePercent =
            Core.sumElems(detectedMat.submat(middleRect)).`val`[0] / 255 / middleRect!!.area()

        val redBorder = Scalar(255.0, 0.0, 0.0)
        val greenBorder = Scalar(0.0, 255.0, 0.0)
        val spikeMark: SpikeMark
        if (leftPercent > middlePercent && leftPercent > leftThreshold) {
            //left is highest
            spikeMark = SpikeMark.LEFT
            Imgproc.rectangle(frame, leftRect, greenBorder)
            Imgproc.rectangle(frame, middleRect, redBorder)
        } else if (middlePercent > leftPercent && middlePercent > middleThreshold) {
            //middle is highest
            spikeMark = SpikeMark.MIDDLE
            Imgproc.rectangle(frame, leftRect, redBorder)
            Imgproc.rectangle(frame, middleRect, greenBorder)
        } else if (middlePercent < middleThreshold && leftPercent < leftThreshold) {
            //right is highest
            spikeMark = SpikeMark.RIGHT
            Imgproc.rectangle(frame, leftRect, redBorder)
            Imgproc.rectangle(frame, middleRect, redBorder)
        } else {
            //team prop not detected
            spikeMark = SpikeMark.UNFOUND
            Imgproc.rectangle(frame, leftRect, redBorder)
            Imgproc.rectangle(frame, middleRect, redBorder)
        }
        if (spikeMark != previousSpikeMark && spikeMark != SpikeMark.UNFOUND) {
            mark = spikeMark
        }
        previousSpikeMark = spikeMark
        return spikeMark
    }

    override fun onDrawFrame(
        canvas: Canvas,
        onscreenWidth: Int,
        onscreenHeight: Int,
        scaleBmpPxToCanvasPx: Float,
        scaleCanvasDensity: Float,
        userContext: Any
    ) {
    }
}