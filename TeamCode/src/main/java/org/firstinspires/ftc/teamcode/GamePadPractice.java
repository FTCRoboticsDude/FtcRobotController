package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class GamePadPractice extends OpMode {

    @Override
    public void init() {
        // Not writing here in initialize
    }

    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y / 2;
        double xDifference = gamepad1.left_stick_x - gamepad1.right_stick_x;
        double rearTriggerSum = gamepad1.left_trigger + gamepad1.right_trigger;

        telemetry.addData("left_stick_x", speedForward);
        telemetry.addData("left_stick_y", gamepad1.left_stick_y);
        telemetry.addData("right_stick_x", gamepad1.left_stick_x);
        telemetry.addData("right_stick_y", gamepad1.left_stick_y);
        telemetry.addData("A", gamepad1.a);
        telemetry.addData("B", gamepad1.b);
        telemetry.addData("X", gamepad1.x);
        telemetry.addData("Y", gamepad1.y);
        telemetry.addData("X Difference", xDifference);
        telemetry.addData("Trigger Sum", rearTriggerSum);

    }
}
