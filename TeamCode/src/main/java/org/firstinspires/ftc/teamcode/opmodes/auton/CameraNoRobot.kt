package org.firstinspires.ftc.teamcode.opmodes.auton

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2

@Autonomous(name = "White Pixel Test")
class CameraNoRobot : LinearOpMode() {
    override fun runOpMode() {
        val robot = VitiTawitiQ2(hardwareMap)
        waitForStart()
        robot.camera.resumeStreaming()
        while (opModeIsActive()) {
            robot.camera.resumeStreaming()
            robot.telemetryTfod(telemetry)
            telemetry.update()
        }
    }

}
