package org.firstinspires.ftc.teamcode.Hardware.Mechanisms

import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.Servo

class ToggleServo(hwMap: HardwareMap, var pos1: Double, var pos2: Double, var name: String) {
    var claw: Servo

    init {
        claw = hwMap.get(Servo::class.java, name)
    }

    fun runTo1() {
        claw.position = pos1
    }

    fun runTo2() {
        claw.position = pos2
    }

    val position: Double
        get() = claw.position
}