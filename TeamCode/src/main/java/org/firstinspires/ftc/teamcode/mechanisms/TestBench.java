package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestBench {
    private DigitalChannel touchSensor; // touchSensorIntake or touchSensorOnClaw
    private DcMotor motor; // linearSlideMotor0 or some other type stuff
    private double ticksPerRev; // revolution
    private DistanceSensor distance;
    private Servo servoPos; // positional servo
    private CRServo servoRot; // continuous rotation servo
    private NormalizedColorSensor colorSensor;
    private IMU imu;

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

        //------------- DISTANCE SENSOR -------------
        distance = hwMap.get(DistanceSensor.class, "sensor_distance");

        //--------------  SERVOS ----------------
        servoPos = hwMap.get(Servo.class, "servo_pos");
        servoRot = hwMap.get(CRServo.class, "servo_rot");
        servoPos.scaleRange(0.5, 1); // sets servoPos range from 0.5 to 1.0
        servoPos.setDirection(Servo.Direction.REVERSE); // reverses servoPos movement
        servoRot.setDirection(DcMotorSimple.Direction.REVERSE); // reverses servoRot movement

        //------------ COLOR SENSORS -------------
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensor_color_distance");
        colorSensor.setGain(8); // sets gain higher than 1 to make values higher; needs tweaking

        //------------ IMU ------------
        imu = hwMap.get(IMU.class, "imu");

        // Orients imu on bot based off of the logo and the usb port
        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );

        // initializes the imu
        imu.initialize(new IMU.Parameters(RevOrientation));

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

     //----------------- Distance Sensor Methods -----------------
    public double getDistance() {
        return distance.getDistance(DistanceUnit.CM); //CM, MM, INCHES, METERS
    }

    //------------------ Servos Methods ------------------
    public void setServoPos(double angle) {
        servoPos.setPosition(angle);
    }
    public void setServoRot(double power) {
        servoRot.setPower(power);
    }

    //---------------- Color Sensors ----------------
    public enum DetectedColor {
        // makes list of colors going to be detected (also includes unknown for unknown values)
        // needs calibration for certain colors
        RED,
        BLUE,
        YELLOW,
        UNKNOWN
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        // returns 4 fraction values: red, green, blue, alpha (brightness)
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        // normalizes colors regardless of distance (divides by alpha)
        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normGreen = colors.green / colors.alpha;
        normBlue = colors.blue / colors.alpha;

        telemetry.addData("Red", normRed);
        telemetry.addData("Green", normGreen);
        telemetry.addData("Blue", normBlue);

        // Fun Fact: You can make TODOs to remember that you have to do something
        /*
        ---------- Calibrating colors ----------
        red, green, blue
        RED = >0.35, <0.3, <0.3
        YELLOW = >0.5, >0.9, <0.6
        BLUE = <0.2, <0.5, >0.5
         */

        if (normRed > 0.35 && normGreen < 0.3 && normBlue < 0.3) {
            return DetectedColor.RED;
        }
        else if (normRed > 0.5 && normGreen > 0.9 && normBlue < 0.6) {
            return DetectedColor.YELLOW;
        }
        else if (normRed < 0.2 && normGreen < 0.5 && normBlue > 0.5) {
            return DetectedColor.BLUE;
        }
        else {
            return DetectedColor.UNKNOWN;
        }
    }

    // -------------- IMU Methods --------------
    public double getHeading(AngleUnit angleUnit) {
        return imu.getRobotYawPitchRollAngles().getYaw(angleUnit);
    }

}
