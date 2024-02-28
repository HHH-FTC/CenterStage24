package org.firstinspires.ftc.teamcode.opmodes.auton

import com.acmerobotics.roadrunner.Pose2d
import com.acmerobotics.roadrunner.Vector2d
import com.acmerobotics.roadrunner.ftc.runBlocking
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2

@Autonomous
class SquarePath : LinearOpMode() {
    override fun runOpMode() {
        val robot = VitiTawitiQ2(hardwareMap)

        waitForStart()

        val traj = robot.drive.actionBuilder(Pose2d(0.0,0.0,0.0))
            .splineTo(Vector2d(24.0,24.0), 0.0)
            .splineTo(Vector2d(-24.0, -24.0), 0.0)
            .build()

        runBlocking(traj)
    }
}