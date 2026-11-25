package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class TeamMemberPractice extends OpMode {

    @Override
    public void init() {

    }

    double squareInputWithSign(double input) {
        double output = input * input;

        if (output < 0) {
            output *= -1;
        }

        return output;
    }

    @Override
    public void loop() {

        double yAxis = gamepad1.left_stick_y;

        telemetry.addData("Left Y Normal", yAxis);

        yAxis = squareInputWithSign(yAxis);

        telemetry.addData("Left Y Modified", yAxis);
    }
}
