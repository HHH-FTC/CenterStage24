package org.firstinspires.ftc.teamcode.opmodes.auton

import com.acmerobotics.roadrunner.Rotation2d
import com.acmerobotics.roadrunner.Vector2d
import com.acmerobotics.roadrunner.ftc.runBlocking
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2

@Autonomous
class ThreeSecondDrive : LinearOpMode() {
    override fun runOpMode() {
        val robot = VitiTawitiQ2(hardwareMap).drive
        waitForStart()

        runBlocking(robot.actionBuilder(robot.pose)
            .splineTo(Vector2d(12.0, 12.0), Rotation2d(0.0, 0.0))
            .build())
    }
}