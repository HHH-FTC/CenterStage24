package org.firstinspires.ftc.teamcode.control

class Path {
    private var actions: MutableList<MoveRobot.Actions>

    constructor() {
        actions = ArrayList()
    }

    constructor(actions: MutableList<MoveRobot.Actions>) {
        this.actions = actions
    }

    fun add(newAction: MoveRobot.Actions, location: Int) {
        val tempArray = actions
        actions[location] = newAction
        for (i in location + 1 until tempArray.size) {
            actions[i + 1] = tempArray[i]
        }
        actions.add(tempArray[tempArray.size - 1])
    }

    fun add(newAction: MoveRobot.Actions): Path {
        add(newAction, actions.size)
        return this
    }

    fun remove(num: Int) {
        actions.removeAt(num)
    }

    fun go() {
        for (action in actions) {
            action.run()
        }
    }
}