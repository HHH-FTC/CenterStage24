package org.firstinspires.ftc.teamcode.opmodes.auton

import com.acmerobotics.roadrunner.Pose2d
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.control.MoveRobot
import org.firstinspires.ftc.teamcode.control.Path
import org.firstinspires.ftc.teamcode.robots.VitiTawitiLIC

@Autonomous
class SquarePath : LinearOpMode() {

    override fun runOpMode() {
        val robot = VitiTawitiLIC(hardwareMap)
        val controller = MoveRobot(robot)
        val path = Path(
            mutableListOf(
                controller.Forward(24),
                controller.StrafeRight(24),
                controller.Backward(24),
                controller.StrafeLeft(24)
            )
        )

        waitForStart()

        path.go()
    }
}