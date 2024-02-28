package org.firstinspires.ftc.teamcode.opmodes.auton

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName
import org.firstinspires.ftc.teamcode.control.vision.RedCvProcessor
import org.firstinspires.ftc.teamcode.robots.VitiTawitiLIC
import org.firstinspires.ftc.vision.VisionPortal

@Autonomous(name = "White Pixel Test")
class CameraNoRobot : LinearOpMode() {
    override fun runOpMode() {
        val robot = VitiTawitiLIC(hardwareMap)
        waitForStart()
        robot.camera.resumeStreaming()
        while (opModeIsActive()) {
            robot.camera.resumeStreaming()
            robot.telemetryTfod(telemetry)
            telemetry.update()
        }
    }
}

@Autonomous(name="Spike Mark Checker")
class SpikeMark : LinearOpMode() {
    override fun runOpMode() {
        val proc = RedCvProcessor()
        val camera = VisionPortal.easyCreateWithDefaults(
            hardwareMap.get(WebcamName::class.java, "Webcam 1"),
            proc
            )

        waitForStart()

        while (opModeIsActive()) {
            telemetry.addData("Spike Mark", proc.mark)
        }
    }

}
