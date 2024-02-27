package org.firstinspires.ftc.teamcode.opmodes.auton

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.robots.VitiTawitiLIC

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
