package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class SelectionStatementPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {

        // Reverses Stick Y Value
        double motorSpeed = -gamepad1.left_stick_y;

        // Creates Deadzone with 0.1
        if (motorSpeed < 0.1 && motorSpeed > -0.1) {
            telemetry.addData("Left Y", "In Deadzone");
        }

        // Turbo Boost with A Button
        if (motorSpeed != 0 && gamepad1.a) {
            motorSpeed *= 1.5;
        }

        telemetry.addData("Left Y Value", motorSpeed);
    }
}
