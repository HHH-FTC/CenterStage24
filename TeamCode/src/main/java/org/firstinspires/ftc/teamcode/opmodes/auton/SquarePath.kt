package org.firstinspires.ftc.teamcode.opmodes.auton

import com.acmerobotics.roadrunner.Vector2d
import com.acmerobotics.roadrunner.ftc.runBlocking
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2

@Autonomous
internal class SquarePath : LinearOpMode() {
    override fun runOpMode() {
        val robot = VitiTawitiQ2(hardwareMap)

        val traj = robot.drive.actionBuilder(robot.drive.pose)
            .setTangent(0.0)
            .strafeTo(Vector2d(0.0, 24.0))
            .strafeTo(Vector2d(24.0, 0.0))
            .strafeTo(Vector2d(0.0, -24.0))
            .strafeTo(Vector2d(-24.0, 0.0))
            .build()

        waitForStart()

        runBlocking(traj) //TOP LEVEL FUNCTION OF ACTIONS.KT
    }
}