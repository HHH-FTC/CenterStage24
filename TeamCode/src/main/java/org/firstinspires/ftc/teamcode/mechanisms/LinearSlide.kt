package org.firstinspires.ftc.teamcode.Hardware.Mechanisms

import org.firstinspires.ftc.teamcode.mechanisms.Motor

class LinearSlide(left: Motor, right: Motor) {
    val left: Motor
    val right: Motor

    init {
        this.left = left
        this.right = right
    }

    fun setPower(power: Double) {
        left.setPower(power)
        right.setPower(power)
    }

    fun on() {
        setPower(1.0)
    }

    fun off() {
        setPower(0.0)
    }
}