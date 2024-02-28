package org.firstinspires.ftc.teamcode.robots

import com.acmerobotics.roadrunner.Pose2d
import com.qualcomm.hardware.lynx.LynxModule
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.teamcode.Hardware.Mechanisms.ToggleServo
import org.firstinspires.ftc.teamcode.mechanisms.Motor
import org.firstinspires.ftc.teamcode.resources.MecanumDrive

class VitiTawitiQ2(hwMap: HardwareMap) : VitiTawiti() {
    override val drive: MecanumDrive
    val intake: Motor
    val slides: Motor
    val claw: ToggleServo
    val lynx: List<LynxModule>
    val launch: ToggleServo

    init {
        drive = MecanumDrive(hwMap, Pose2d(0.0, 0.0, 0.0))

        slides = Motor("slides", hwMap)
        slides.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE)

        intake = Motor("intake", hwMap)
        intake.setDirectionReverse()

        lynx = hwMap.getAll(LynxModule::class.java)

        launch = ToggleServo(hwMap, 0.0, .6, "launch")
        claw = ToggleServo(hwMap, 0.0, .5, "claw")
    }

    fun teleOpIntake(gp: Gamepad) {
        if (gp.a) {
            intake.setPower(0.5)
        } else if (gp.b) {
            intake.setPower(0.0)
        }
    }
}