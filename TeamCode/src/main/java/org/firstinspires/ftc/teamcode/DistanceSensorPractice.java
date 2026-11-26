package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class DistanceSensorPractice extends OpMode {
    TestBench bench = new TestBench();
    double distance = bench.getDistance();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Distance Sensor", bench.getDistance());

        if (distance < 10) {
            telemetry.addData("Distance", "Too Close");
        }
    }
}
