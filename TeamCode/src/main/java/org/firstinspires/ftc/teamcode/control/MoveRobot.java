package org.firstinspires.ftc.teamcode.control;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.Motor;
import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2;

import java.util.ArrayList;

public class MoveRobot {
    VitiTawitiQ2 robot;
    HardwareMap hardwareMap;
    final int ONE_BOX = 538;
    ArrayList<Path> paths;
    DcMotorEx fLeft, fRight, bLeft, bRight;

    public MoveRobot(VitiTawitiQ2 robot, HardwareMap hardwareMap) {
        this.robot = robot;
        this.hardwareMap = hardwareMap;
        fLeft = robot.getDrive().leftFront;
        fRight = robot.getDrive().rightFront;
        bLeft = robot.getDrive().leftBack;
        bRight = robot.getDrive().rightBack;
    }

    public void addPath(ArrayList<String> actions) {
        paths.add(new Path(actions));
    }

    public void addToPath(int pathId, String action, int location) {
        paths.get(pathId).add(action,location);
    }

    public void addToPath(int pathId, String action) {
        paths.get(pathId).add(action);
    }

    public void removeFromPath(int pathId, int location) {
        paths.get(pathId).remove(location);
    }

    public void strafeLeft() {
        fLeft.setTargetPosition(ONE_BOX);
        fRight.setTargetPosition(ONE_BOX);
        bLeft.setTargetPosition(ONE_BOX);
        bRight.setTargetPosition(ONE_BOX);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(.85);
        fRight.setPower(-.85);
        bLeft.setPower(-.85);
        bRight.setPower(.85);
    }

    public void strafeRight() {
        fLeft.setTargetPosition(ONE_BOX);
        fRight.setTargetPosition(ONE_BOX);
        bLeft.setTargetPosition(ONE_BOX);
        bRight.setTargetPosition(ONE_BOX);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(-.85);
        fRight.setPower(.85);
        bLeft.setPower(.85);
        bRight.setPower(-.85);
    }

    public void forward() {
        fLeft.setTargetPosition(ONE_BOX);
        fRight.setTargetPosition(ONE_BOX);
        bLeft.setTargetPosition(ONE_BOX);
        bRight.setTargetPosition(ONE_BOX);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(.85);
        fRight.setPower(.85);
        bLeft.setPower(.85);
        bRight.setPower(.85);
    }

    public void backward() {
        fLeft.setTargetPosition(ONE_BOX);
        fRight.setTargetPosition(ONE_BOX);
        bLeft.setTargetPosition(ONE_BOX);
        bRight.setTargetPosition(ONE_BOX);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(-.85);
        fRight.setPower(-.85);
        bLeft.setPower(-.85);
        bRight.setPower(-.85);
    }

    public void strafeLeft(int amount) {
        fLeft.setTargetPosition(ONE_BOX*amount);
        fRight.setTargetPosition(ONE_BOX*amount);
        bLeft.setTargetPosition(ONE_BOX*amount);
        bRight.setTargetPosition(ONE_BOX*amount);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(.85);
        fRight.setPower(-.85);
        bLeft.setPower(-.85);
        bRight.setPower(.85);
    }

    public void strafeRight(int amount) {
        fLeft.setTargetPosition(ONE_BOX*amount);
        fRight.setTargetPosition(ONE_BOX*amount);
        bLeft.setTargetPosition(ONE_BOX*amount);
        bRight.setTargetPosition(ONE_BOX*amount);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(-.85);
        fRight.setPower(.85);
        bLeft.setPower(.85);
        bRight.setPower(-.85);
    }

    /* acts = [new StrafeRight(4), new Forward(), new RotateCW(90)]
        for (action act : acts) {
            act.run()
        } */

    /*

    acts = {"strafeRight(4)", "forward"}

    for(int i=0; i<acts.size(


    */

    public void forward(int amount) {
        fLeft.setTargetPosition(ONE_BOX*amount);
        fRight.setTargetPosition(ONE_BOX*amount);
        bLeft.setTargetPosition(ONE_BOX*amount);
        bRight.setTargetPosition(ONE_BOX*amount);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(-.85);
        fRight.setPower(-.85);
        bLeft.setPower(-.85);
        bRight.setPower(-.85);
    }

    public void backward(int amount) {
        fLeft.setTargetPosition(ONE_BOX*amount);
        fRight.setTargetPosition(ONE_BOX*amount);
        bLeft.setTargetPosition(ONE_BOX*amount);
        bRight.setTargetPosition(ONE_BOX*amount);

        fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        fLeft.setPower(.85);
        fRight.setPower(.85);
        bLeft.setPower(.85);
        bRight.setPower(.85);

    }

    private class Path {
        ArrayList<String> actions;

        public Path() {
            actions = new ArrayList<String>();
        }

        public Path(ArrayList<String> actions) {
            this.actions = actions;
        }

        public void add(String newAction, int location) {
            ArrayList<String> tempArray = actions;

            actions.set(location,newAction);

            for(int i=location+1; i<tempArray.size(); i++) {
                actions.set(i+1,tempArray.get(i));
            }

            actions.add(tempArray.get(tempArray.size()-1));
        }

        public void add(String newAction) {
            add(newAction, actions.size());
        }

        public void remove(int num) {
            actions.remove(num);
        }

        public void go() {
            for(String action : actions) {
                switch(action) {
                    case "forward":
                        forward();
                        break;
                    case "backward":
                        backward();
                        break;
                    case "strafeLeft":
                        strafeLeft();
                        break;
                    case "strafeRight":
                        strafeRight();
                        break;
                    case "forward(":
                        forward(action.charAt(8));
                        break;
                    case "backward(":
                        backward(action.charAt(9));
                        break;
                    case "strafeLeft(":
                        strafeLeft(action.charAt(11));
                        break;
                    case "strafeRight(":
                        strafeRight(action.charAt(12));
                        break;
                }
            }
        }
    }
}
