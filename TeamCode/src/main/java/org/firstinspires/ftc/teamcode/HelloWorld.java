package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@Autonomous
public class HelloWorld extends OpMode {

    //Adds data into the initialization code
    @Override
    public void init() {
        telemetry.addData("Hello", "Nathan");
    }

    @Override
    public void loop() {

    }
}