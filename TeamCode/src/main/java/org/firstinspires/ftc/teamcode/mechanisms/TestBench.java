package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DigitalChannel touchSensor; // touchSensorIntake or touchSensorOnClaw

    public void init(HardwareMap hwMap) {
        // attributes touchSensor to "touch_sensor" in Control Hub
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        // sets touchSensor as an INPUT (sends signals to the control hub)
        touchSensor.setMode(DigitalChannel.Mode.INPUT);

    }

    // creates getter method to get data from touchSensor
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }
}
