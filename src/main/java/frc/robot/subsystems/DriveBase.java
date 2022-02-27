package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.SPI;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveBase extends SubsystemBase {
    // A class that creates the Drivebase
    /* Drivebase Diagram
      ___________
    0|-         -|0
     | -       - |
    0|--       --|0
     | -       - |
    0|-_________-|0
    
    */

    // Ports for Toaster
    // Declaring the motors for the left side
    public WPI_TalonSRX leftMiddleMaster;
    
    public WPI_VictorSPX leftFrontMotor;
    public WPI_VictorSPX leftBackMotor;
    
    // declaring the motors for the right side
    public WPI_TalonSRX rightMiddleMaster;

    public WPI_VictorSPX rightFrontMotor;
	public WPI_VictorSPX rightBackMotor;
	
	// Ports for Falcon
	public WPI_TalonFX leftFront;
	public WPI_TalonFX rightFront;
	public WPI_TalonFX leftBack;
	public WPI_TalonFX rightBack;

	// Ports for Anti mech
	public WPI_TalonSRX leftLeader;
	public WPI_TalonSRX leftFollower;
	public WPI_TalonSRX rightLeader;
	public WPI_TalonSRX rightFollower;

    public MotorControllerGroup leftMotorGroup;
	public MotorControllerGroup rightMotorGroup;
	
	// Encoder value programming
	public double leftEncoderValue;
	public double rightEncoderValue;

	// Gyro initializing
	// public ADXRS450_Gyro gyroBoi;

	// Creating tankDrive instance
	public DifferentialDrive tank;
	
	// In case declaring the enum doesn't work directly in the gyro contructor:
	// public static final SPI.Port gyroPort = SPI.Port.kOnboardCS0;

    public DriveBase(){
		// required for Subsystems and commands as a way to tell program who do communicate with
		setSubsystem("DriveBase");

		this.leftFront = new WPI_TalonFX(RobotMap.leftFront);
		this.rightFront = new WPI_TalonFX(RobotMap.rightFront);
		this.leftBack = new WPI_TalonFX(RobotMap.leftBack);
		this.rightBack = new WPI_TalonFX(RobotMap.rightBack);

		this.leftMotorGroup = new MotorControllerGroup(leftFront, leftBack);
		this.rightMotorGroup = new MotorControllerGroup(rightFront, rightBack);
		// Building the actual robot drive train
		this.tank = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
    }

	/**
	 * A manual way to set the motor speeds on the drivetrain
	 * @param leftSide - motor velocity for the left side (from -1 to 1)
	 * @param rightSide - motor velocity for the right side (from -1 to 1)
	 */
    public void setSpeed(double leftSide, double rightSide){
        leftMotorGroup.set(leftSide);
        rightMotorGroup.set(rightSide);
    }
	
	/**
	 * Stops the motors from running
	 */
    public void stopMotors(){
		leftMotorGroup.set(0);
		rightMotorGroup.set(0);
	}	
	
	/**
	 * resets the Gyro to 0
	 */
	public void resetGyroAngle(){
		// gyroBoi.reset();
	}
	
	/**
	 * Gets the gyro angle relative to the last point of reset
	 * @return Returns the angle deviating from the last reset angle
	 */
	public double getGyroAngle(){
		// return gyroBoi.getAngle();
        return 422;
	}
	
	/**
	 * Recalibrates both encoders to compare with future encoder positions
	 */
	public void reCalibrateEncoders(){
		this.leftEncoderValue = leftMiddleMaster.getSelectedSensorPosition(0);
		this.rightEncoderValue = rightMiddleMaster.getSelectedSensorPosition(0);		
	}

	/**
	 * Finds the current encoder position of the left encoder
	 * @return Returns the difference between where the sensor is now to where the sensor was at the previous calibration
	 */
	public double getLeftEncoder(){
		return leftMiddleMaster.getSelectedSensorPosition(0) - leftEncoderValue;
	}

	/**
	 * Finds the current encoder position of the right encoder
	 * @return Returns the difference between where the sensor is now to where the sensor was at the previous calibration
	 */
	public double getRightEncoder(){
		return rightMiddleMaster.getSelectedSensorPosition(0) - rightEncoderValue;
	}
}
