package org.firstinspires.ftc.teamcode.control;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

    public void addPath(ArrayList<Actions> actions) {
        paths.add(new Path(actions));
    }

    public void addToPath(int pathId, Actions action, int location) {
        paths.get(pathId).add(action,location);
    }

    public void addToPath(int pathId, Actions action) {
        paths.get(pathId).add(action);
    }

    public void removeFromPath(int pathId, int location) {
        paths.get(pathId).remove(location);
    }

    public void strafeLeft() {
        strafeLeft(1);
    }

    public void strafeRight() {
        strafeRight(1);
    }

    public void forward() {
        forward(1);
    }

    public void backward() {
        backward(1);
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
        ArrayList<Actions> actions;

        public Path() {
            actions = new ArrayList<Actions>();
        }

        public Path(ArrayList<Actions> actions) {
            this.actions = actions;
        }

        public void add(Actions newAction, int location) {
            ArrayList<Actions> tempArray = actions;

            actions.set(location,newAction);

            for(int i=location+1; i<tempArray.size(); i++) {
                actions.set(i+1,tempArray.get(i));
            }

            actions.add(tempArray.get(tempArray.size()-1));
        }

        public void add(Actions newAction) {
            add(newAction, actions.size());
        }

        public void remove(int num) {
            actions.remove(num);
        }


        public void go() {
            for(Actions action : actions) {
                action.run();
            }
        }
    }

    interface Actions {
        void run();
    }

    class Forward implements Actions {
        private int amount;
        public Forward() {amount = 1;}
        public Forward(int amount) {this.amount = amount;}
        @Override
        public void run() {
            forward(amount);
        }
    }

    class Backward implements Actions {
        private int amount;
        public Backward() {amount = 1;}
        public Backward(int amount) {this.amount = amount;}
        @Override
        public void run() {
            forward(amount);
        }
    }

    class StrafeLeft implements Actions {
        private int amount;
        public StrafeLeft() {amount = 1;}
        public StrafeLeft(int amount) {this.amount = amount;}
        @Override
        public void run() {
            strafeLeft(amount);
        }
    }

    class StrafeRight implements Actions {
        private int amount;
        public StrafeRight() {amount = 1;}
        public StrafeRight(int amount) {this.amount = amount;}
        @Override
        public void run() {
            strafeRight(amount);
        }
    }
}
