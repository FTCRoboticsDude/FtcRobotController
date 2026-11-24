package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Main extends OpMode {
    @Override
    public void init() {
        int teamNumber = 36054;
        double motorSpeed = 0.75;
        int motorAngle = 90;
        boolean clawClosed = true;
        String TeamName = "EagleTech";

        telemetry.addData("Team Name", TeamName);
        telemetry.addData("Motor Angle", motorAngle);
        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Claw State", clawClosed);
    }

    @Override
    public void loop() {

    }
}
