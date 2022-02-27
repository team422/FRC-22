package frc.robot.subsystems.drivebases;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Drivebase interface for all drivebases
 */
public abstract class DriveBase extends SubsystemBase {

    public MotorControllerGroup leftSide;
    public MotorControllerGroup rightSide;
    public DifferentialDrive driveBase;

    public double leftMotorTicks = 0;
    public double rightMotorTicks = 0;

    public DriveBase() {
        setSubsystem("DriveBase");

        this.setMotors();
        this.driveBase = new DifferentialDrive(leftSide, rightSide);
    }

    public abstract void setMotors();

    /**
     * Sets drive train motors.
     * @param left Left side motors' velocity (-1 to 1)
     * @param right Right side motors' velocity (-1 to 1)
     */
    public void setMotors(double left, double right) {
        leftSide.set(left);
        rightSide.set(right);
    }

    /**
     * Sets the left side drive train motors
     * @param left Left side motors' velocity (-1 to 1)
     */
    public void setLeftMotors(double left) {
        leftSide.set(left);
    }

    /**
     * Sets the right side drive train motors
     * @param right Right side motors' velocity (-1 to 1)
     */
    public void setRightMotors(double right) {
        rightSide.set(right);
    }

    /**
     * Sets drive train motors to zero, effectively stopping the bot.
     */
    public void stopMotors() {
        leftSide.stopMotor();
        rightSide.stopMotor(); //better apparently according to Yash (stopMotor instead of set(0))
    }

    public void curvatureDrive(double xSpeed, double zRotation, boolean allowTurnInPlace){
        driveBase.curvatureDrive(xSpeed, zRotation, allowTurnInPlace);
    }

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squareInputs){
        driveBase.tankDrive(leftSpeed, rightSpeed, squareInputs);
    }

    public void arcadeDrive(double xSpeed, double zRotation, boolean squareInputs){
        driveBase.arcadeDrive(xSpeed, zRotation, squareInputs);
    }

    /**
     * @return Left side position in ticks. If statement exists because Falcon uses a different motor as leader than 
     * the other drivebases 
     */
    public abstract double getLeftPosition();

    /**
     * @return Right side position in ticks.
     */
    public abstract double getRightPosition();

    /**
     * @return Angle at which the robot is positioned in degrees
     */
    public abstract double getGyroAngle();

    /**
     * Resets the reference point used to calculate distance traveled. Does not physically change the encoder value.
     */
    public abstract void zeroEncoderPosition();

    /**
     * Sets the gyro angle to zero.
     */
    public abstract void zeroGyroAngle();
}
