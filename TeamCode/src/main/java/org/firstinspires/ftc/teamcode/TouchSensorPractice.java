package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class TouchSensorPractice extends OpMode {
    // create new member with name bench
    TestBench bench = new TestBench();

    @Override
    public void init() {
        // runs init method from TestBench.java to grab data and set as INPUT
        bench.init(hardwareMap);

    }

    @Override
    public void loop() {
        String touchSensorState = "NOT Pressed!";
        if (bench.isTouchSensorPressed()) {
            touchSensorState = "Pressed!";
        }

        telemetry.addData("Touch Sensor State", touchSensorState);
    }
}
