package org.firstinspires.ftc.teamcode;

public class RobotLocationPractice {

    double angle;
    double x;
    double y;

    // Constructor Method
    public RobotLocationPractice(double angle) {
        this.angle = angle;
    }

    public double getHeading() {

        double angle = this.angle;

        while (angle > 180) {
            angle -= 360;
        }
        while (angle <= -180) {
            angle += 360;
        }

        return angle;
    }
    public void turnRobot(double angleChange) {
        angle += angleChange;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public double getAngle() {
        return this.angle;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return this.x;
    }

    public void changeX(double changeAmount) {
        x += changeAmount;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return this.y;
    }

    public void changeY(double changeAmount) {
        y += changeAmount;
    }
}
