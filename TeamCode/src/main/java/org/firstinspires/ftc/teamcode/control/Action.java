package org.firstinspires.ftc.teamcode.control;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {
    DcMotorEx fLeft, fRight, bLeft, bRight;
    protected int target;
    protected final int ONE_BOX = 538;

    public Action(HardwareMap hwMap, int target) {
        VitiTawitiQ2 robot = new VitiTawitiQ2(hwMap);
        fLeft = robot.getDrive().leftFront;
        fRight = robot.getDrive().rightFront;
        bLeft = robot.getDrive().leftBack;
        bRight = robot.getDrive().rightBack;
        this.target = target;
    }

    abstract void run();

    public class Forward extends Action {

        public Forward(HardwareMap hwMap, int target) {
            super(hwMap, target);
        }

        @Override
        void run() {
            fLeft.setTargetPosition(ONE_BOX * target);
            fRight.setTargetPosition(ONE_BOX * target);
            bLeft.setTargetPosition(ONE_BOX * target);
            bRight.setTargetPosition(ONE_BOX * target);

            fLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            fRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            bLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            bRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

            fLeft.setPower(.85);
            fRight.setPower(.85);
            bLeft.setPower(.85);
            bRight.setPower(.85);
        }
    }

    public class Path {
        List<Action> traj;

        public Path() {
            traj = new ArrayList<>();
        }

        public Path add(Action a) {
            traj.add(a);
            return this;
        }

        public void execute() {
            for (Action act : traj) {
                act.run();
            }
        }
    }

    public class Whatever extends LinearOpMode {
        public void runOpMode() {
            Path p = new Path();
            p = p.add(new Forward(hardwareMap, 1)).add(new Forward(hardwareMap, -20));
            p.execute();
        }
    }
}
