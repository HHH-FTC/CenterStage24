package org.firstinspires.ftc.teamcode.robots

import com.acmerobotics.roadrunner.Pose2d
import com.acmerobotics.roadrunner.Vector2d
import com.qualcomm.hardware.lynx.LynxModule
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName
import org.firstinspires.ftc.teamcode.Hardware.Mechanisms.LinearSlide
import org.firstinspires.ftc.teamcode.Hardware.Mechanisms.ToggleServo
import org.firstinspires.ftc.teamcode.mechanisms.Motor
import org.firstinspires.ftc.teamcode.resources.MecanumDrive
import org.firstinspires.ftc.vision.VisionPortal
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor
import org.firstinspires.ftc.vision.tfod.TfodProcessor

class VitiTawitiLIC(hwMap: HardwareMap) : VitiTawiti() {
    override val drive: MecanumDrive
    val intake: Motor
    val slides1: LinearSlide
    val slides2: LinearSlide //each slide is powered separately now
    val claw: ToggleServo
    val lynx: List<LynxModule> //control hub + expansion hub
    val camera: VisionPortal
    val tf: TfodProcessor
    val atag: AprilTagProcessor
    val launch: ToggleServo
    //TODO: implement Ori's linear servos for locking

    init {
        drive = MecanumDrive(hwMap, Pose2d(0.0, 0.0, 0.0))

        val slide1M = Motor("slides", hwMap)
        slide1M.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE)
        val slide2M = Motor("slides2", hwMap)
        slide2M.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE)
        slide2M.setDirectionReverse()

        slides1 = LinearSlide(slide1M, 0.0, 500.0, 250.0)
        slides2 = LinearSlide(slide2M, 0.0, 500.0, 250.0)

        intake = Motor("intake", hwMap)
        intake.setDirectionReverse()


        lynx = hwMap.getAll(LynxModule::class.java)

        launch = ToggleServo(hwMap, 0.0, .6, "claw")
        claw = ToggleServo(hwMap, 0.0, .5, "launch")

        tf = TfodProcessor.easyCreateWithDefaults()
        atag = AprilTagProcessor.easyCreateWithDefaults()
        camera = VisionPortal.easyCreateWithDefaults(
            hwMap.get(WebcamName::class.java, "Webcam 1"),
            tf,
            atag

        )

        this.drive.backLeft.direction = DcMotorSimple.Direction.REVERSE
    }



    fun teleOpIntake(gp: Gamepad) {
        if (gp.a) {
            intake.setPower(0.5)
        } else if (gp.b) {
            intake.setPower(0.0)
        }
    }

    fun telemetryTfod(telemetry: Telemetry) {
        val currentRecognitions = tf.recognitions
        telemetry.addData("# Objects Detected", currentRecognitions.size)

        // Step through the list of recognitions and display info for each one.
        for (recognition in currentRecognitions) {
            val x = ((recognition.left + recognition.right) / 2).toDouble()
            val y = ((recognition.top + recognition.bottom) / 2).toDouble()
            telemetry.addData("Test", "Test")
            telemetry.addData(
                "Image",
                "%s (%.0f %% Conf.)",
                recognition.label,
                recognition.confidence * 100
            )
            telemetry.addData("- Position", "%.0f / %.0f", x, y)
            telemetry.addData("- Size", "%.0f x %.0f", recognition.width, recognition.height)
        } // end for() loop
    } // end method telemetryTfod()

    fun getRecPoints(): List<Vector2d> {
        val recs = tf.recognitions
        val points = mutableListOf<Vector2d>()
        for (rec in recs) {
            val x = ((rec.left + rec.right) / 2).toDouble()
            val y = ((rec.top + rec.bottom) / 2).toDouble()

            points.add(Vector2d(x, y))
        }

        return points
    }

    enum class PixelSpot {
        LEFT,
        MIDDLE,
        RIGHT
    }

    fun pixelSpot() {
    }
}