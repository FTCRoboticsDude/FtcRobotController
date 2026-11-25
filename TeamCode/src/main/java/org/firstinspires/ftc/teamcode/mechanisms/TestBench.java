package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DigitalChannel touchSensor; // touchSensorIntake or touchSensorOnClaw
    private DcMotor motor; // linearSlideMotor0 or some other type stuff
    private double ticksPerRev; // revolution

    public void init(HardwareMap hwMap) {
        //--------------- TOUCH SENSOR --------------
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor"); // attributes touchSensor to "touch_sensor" in Control Hub
        touchSensor.setMode(DigitalChannel.Mode.INPUT); // sets touchSensor as an INPUT (sends signals to the control hub)

        // ------------ DC MOTOR -------------
        motor = hwMap.get(DcMotor.class, "motor"); // attributes motor to "motor" in Control Hub
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // sets mode to run using encoder to a set speed
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // fully brakes motor
        motor.setDirection(DcMotorSimple.Direction.REVERSE); // reverses direction of motor

    }

    //----------touchSensor Methods------------
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }
    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }

    //----------motor Methods------------
    public void setMotorSpeed(double speed) {
        motor.setPower(speed); // accepts values -1.0 to 1.0
    }
    public double getMotorRevs() {
        // total ticks / ticks per rev = revolutions
        return motor.getCurrentPosition() / ticksPerRev;
    }
     public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
     }
}
