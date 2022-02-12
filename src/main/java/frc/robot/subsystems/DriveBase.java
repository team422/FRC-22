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

		// For the Toaster

		// Declares the instantiated variables that store the motor controller objects
		// Setting left motors to their respective motor objects
        // this.leftMiddleMaster = new WPI_TalonSRX(RobotMap.leftMiddleMasterPort);
        // this.leftFrontMotor = new WPI_VictorSPX(RobotMap.leftFrontFollower);
        // this.leftBackMotor = new WPI_VictorSPX(RobotMap.leftBackFollower);
		
		// // Setting right motors to their respective motor objects
        // this.rightMiddleMaster = new WPI_TalonSRX(RobotMap.rightMiddleMasterPort);        
        // this.rightFrontMotor = new WPI_VictorSPX(RobotMap.rightFrontFollower);
		// this.rightBackMotor = new WPI_VictorSPX(RobotMap.rightBackFollower);

		// this.leftLeader = new WPI_TalonSRX(RobotMap.leftLeader);
		// this.leftFollower = new WPI_TalonSRX(RobotMap.leftFollower);
		// this.rightLeader = new WPI_TalonSRX(RobotMap.rightLeader);
		// this.rightFollower = new WPI_TalonSRX(RobotMap.rightFollower);
		
		// Since we use the same type of motors, both think that front is clockwise,
		// but on the left side, the clockwise rotation causes it to move backward,
		// thus inverting it causes both motors to move in the correct way
		// leftMiddleMaster.setInverted(true);
		// leftFrontMotor.setInverted(true);
		// leftBackMotor.setInverted(true);
        
        // this.leftMotorGroup = new MotorControllerGroup(leftLeader, leftFollower);
        // this.rightMotorGroup = new MotorControllerGroup(rightLeader, rightFollower);

		// For Falcon

		this.leftFront = new WPI_TalonFX(RobotMap.leftFront);
		this.rightFront = new WPI_TalonFX(RobotMap.rightFront);
		this.leftBack = new WPI_TalonFX(RobotMap.leftBack);
		this.rightBack = new WPI_TalonFX(RobotMap.rightBack);

		this.leftMotorGroup = new MotorControllerGroup(leftFront, leftBack);
		this.rightMotorGroup = new MotorControllerGroup(rightFront, rightBack);
		// Building the actual robot drive train
		this.tank = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
		
		// Setting up and getting the encoder values
		// this.leftEncoderValue = leftMiddleMaster.getSelectedSensorPosition(0);
		// this.rightEncoderValue = rightMiddleMaster.getSelectedSensorPosition(0);
		
		// Gyro with SPI.Port.kOnboardCS0 being the port enum that is provided by WPILib
		// this.gyroBoi = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
		
		// Built in check if the gyro is the correct one and it is connected
		// System.out.println(gyroBoi.isConnected)
		// Might not work, check when working with robot
		// gyroBoi.calibrate();
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
