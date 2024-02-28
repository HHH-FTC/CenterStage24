package org.firstinspires.ftc.teamcode.opmodes.teleop

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit
import org.firstinspires.ftc.teamcode.robots.VitiTawitiLIC

@TeleOp
class LICTeleOp : LinearOpMode() {

    override fun runOpMode() {
        val robot = VitiTawitiLIC(hardwareMap)
        robot.claw.runTo1()

        waitForStart()
        while (opModeIsActive()) {
            robot.teleOpIntake(gamepad1)

            if (gamepad1.right_trigger > 0) {
                robot.claw.runTo2()
            } else if (gamepad1.left_trigger > 0) {
                robot.deposit(this)
            } else if (gamepad1.left_bumper) {
                robot.claw.runTo1()
            } else if (gamepad1.right_bumper) {
                robot.claw.runTo2()
            } else if (gamepad1.dpad_right) {
                robot.launch.runTo2()
            } else if (gamepad1.dpad_left) {
                robot.launch.runTo1()
            } else if (gamepad1.dpad_up) {
                robot.slides.on()
            } else if (gamepad1.dpad_down) {
                robot.slides.setPower(-1.0)
            } else {
                robot.slides.off()
            }


            telemetry.addData(
                "Slide Current",
                robot.slides.left.dcMotorEx.getCurrent(CurrentUnit.AMPS)
            )
            telemetry.addData("Slide Position", robot.slides.left.currentPosition)
            telemetry.addData("Claw Position", robot.claw.position)
            telemetry.addData("Positions:", robot.teleOpDrive(gamepad1))
            telemetry.update()
        }
    }

}