package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class ServosPractice extends OpMode {
    TestBench bench = new TestBench();
    double rightTriggerValue = gamepad1.right_trigger;

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        // servoPos range from 0.0 to 1.0, 0.5 as midpoint
        if (gamepad1.a) {
            bench.setServoPos(0);
        }
        else {
            bench.setServoPos(1);
        }

        // not verified but the range may be from 0 to 1
        if (gamepad1.b) {
            bench.setServoRot(1);
        }
        else {
            bench.setServoRot(0);
        }
    }
}
