package org.firstinspires.ftc.teamcode.control;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2;

import java.util.ArrayList;

public class Move {
    VitiTawitiQ2 robot;
    HardwareMap hardwareMap;
    final int ONE_BOX = 538;
    ArrayList<Path> paths;
    DcMotorEx fLeft, fRight, bLeft, bRight;

    public Move(VitiTawitiQ2 robot, HardwareMap hardwareMap) {
        this.robot = robot;
        this.hardwareMap = hardwareMap;
        fLeft = robot.getDrive().frontLeft;
        fRight = robot.getDrive().frontRight;
        bLeft = robot.getDrive().backLeft;
        bRight = robot.getDrive().backRight;
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

    public void addPath(ArrayList<String> actions) {
        paths.add(new Path(actions));
    }

    public void newPath() {
        paths.add(new Path());
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

    public void runPath(int pathId) {
        paths.get(pathId).run();
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

        public void run() {
            for (String action : actions) {
                switch (action) {
                    case "forward":
                        forward(1);
                        break;
                    case "backward":
                        backward(1);
                        break;
                    case "strafeLeft":
                        strafeLeft(1);
                        break;
                    case "strafeRight":
                        strafeRight(1);
                        break;
                }
            }
        }
    }
}