package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class DCMotorPractice extends OpMode {
    TestBench bench = new TestBench();

    @Override
    public void init() {
        // runs init to set encoder to 0 and attribute motor to "motor" in Control Hub
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        // sets motorSpeed to value on left stick y
        double motorSpeed = gamepad1.left_stick_y;
        boolean aButton = gamepad1.a;
        boolean bButton = gamepad1.b;

        //runs motor at half speed
        bench.setMotorSpeed(motorSpeed);

        if (gamepad1.a) {
            bench.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        else if (gamepad1.b) {
            bench.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        telemetry.addData("Number of Revolutions", bench.getMotorRevs());
    }
}
