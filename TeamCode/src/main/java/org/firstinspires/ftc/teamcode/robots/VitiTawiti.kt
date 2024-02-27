package org.firstinspires.ftc.teamcode.robots

import com.acmerobotics.roadrunner.PoseVelocity2d
import com.acmerobotics.roadrunner.Vector2d
import com.qualcomm.robotcore.hardware.Gamepad
import org.firstinspires.ftc.teamcode.resources.MecanumDrive

abstract class VitiTawiti {
    abstract val drive: MecanumDrive

     fun teleOpDrive(gamepad: Gamepad): PoseVelocity2d {
        val loc = PoseVelocity2d(
            Vector2d(
                -gamepad.left_stick_y.toDouble(),
                -gamepad.left_stick_x.toDouble()
            ),
            -gamepad.right_stick_x.toDouble()
        )
        drive.setDrivePowers(loc)
        return loc
    }
}