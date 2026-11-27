package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class IMUPractice extends OpMode {
    TestBench bench = new TestBench();
    double heading;

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        heading = bench.getHeading(AngleUnit.DEGREES);
        telemetry.addData("Heading", heading);

        if (heading < 0.5 && heading > -0.5) {
            bench.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        else if (heading < -0.5) {
            bench.setMotorSpeed(1.0);
        }
        else if (heading > 0.5) {
            bench.setMotorSpeed(-1.0);
        }
    }
}
