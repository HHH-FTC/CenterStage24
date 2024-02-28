package org.firstinspires.ftc.teamcode.opmodes.auton

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2

@Autonomous
class OneSecondDrive : LinearOpMode() {
    override fun runOpMode() {
        val robot = VitiTawitiQ2(hardwareMap).drive

        waitForStart()

        robot.frontLeft.power = .5
        robot.frontRight.power = 0.5
        robot.backRight.power = .5
        robot.backLeft.power = .5

        sleep(1000)

        robot.frontLeft.power = 0.0
        robot.frontRight.power = 0.0
        robot.backRight.power = 0.0
        robot.backLeft.power = 0.0

    }
}