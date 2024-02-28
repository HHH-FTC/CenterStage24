package org.firstinspires.ftc.teamcode.opmodes.teleop

import com.acmerobotics.roadrunner.Pose2d
import com.acmerobotics.roadrunner.PoseVelocity2d
import com.acmerobotics.roadrunner.Vector2d
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.resources.MecanumDrive

@TeleOp
class MecanumTeleOp : LinearOpMode() {

    override fun runOpMode() {
        val robot = MecanumDrive(hardwareMap, Pose2d(0.0, 0.0, 0.0))

        waitForStart()

        while (opModeIsActive()) {
            robot.setDrivePowers(PoseVelocity2d(
                Vector2d(
                    -gamepad1.left_stick_y.toDouble(),
                    -gamepad1.left_stick_x.toDouble()
                ),
                -gamepad1.right_stick_x.toDouble()
            ))
        }
    }
}