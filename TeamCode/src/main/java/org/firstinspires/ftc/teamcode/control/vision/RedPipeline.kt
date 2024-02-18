package org.firstinspires.ftc.teamcode.control.vision

import android.graphics.Canvas
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration
import org.firstinspires.ftc.vision.VisionProcessor
import org.opencv.core.Mat

class RedPipeline : VisionProcessor{
    override fun init(width: Int, height: Int, calibration: CameraCalibration?) {

    }

    override fun processFrame(frame: Mat, captureTimeNanos: Long): Any {
        val thirdWidth = frame.width() / 3
        return TODO()
    }

    override fun onDrawFrame(
        canvas: Canvas?,
        onscreenWidth: Int,
        onscreenHeight: Int,
        scaleBmpPxToCanvasPx: Float,
        scaleCanvasDensity: Float,
        userContext: Any?
    ) {
        TODO("Not yet implemented")
    }

}