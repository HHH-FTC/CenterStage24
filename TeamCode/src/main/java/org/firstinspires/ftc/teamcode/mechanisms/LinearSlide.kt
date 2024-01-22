package org.firstinspires.ftc.teamcode.Hardware.Mechanisms

import org.firstinspires.ftc.teamcode.mechanisms.Motor

class LinearSlide (
    val motor: Motor,
    var zero: Double,
    var target: Double,
    var increment: Double
) {
    var advance = 0
    fun goToZero() {
        motor.runToPosition(zero)
    }

    fun goToOne() {
        motor.runToPosition(target + increment * advance)
    }

    fun advance() {
        advance += 1
    }

    fun unadvance() {
        advance -= 1
    }

    fun setPower(power: Double) {
        motor.setPower(power);
    }
}