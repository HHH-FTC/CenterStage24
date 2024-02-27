package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.control.Move;
import org.firstinspires.ftc.teamcode.robots.VitiTawitiQ2;

import java.util.ArrayList;

@Autonomous
public class PathSystem extends LinearOpMode {
   @Override
   public void runOpMode() {
       VitiTawitiQ2 robot = new VitiTawitiQ2(hardwareMap);
       waitForStart();
       Move move = new Move(robot, hardwareMap);

       ArrayList<String> path1 = new ArrayList<String>();
       path1.add("forward");
       path1.add("strafeLeft");

       move.addPath(path1);
       move.runPath(0);
   }
}
