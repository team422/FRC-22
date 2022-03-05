package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class FalconDrive extends DriveBase {
    private static final int leftFrontPort = 7;
    private static final int leftRearPort = 6;
    private static final int rightFrontPort = 11;
    private static final int rightRearPort = 5;

    private WPI_TalonFX leftFront;
    private WPI_TalonFX leftRear;
    private WPI_TalonFX rightFront;
    private WPI_TalonFX rightRear;

    private ADXRS450_Gyro gyro;
    private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;

    public FalconDrive() {
        
    }

    public void motorize(){
        this.leftFront = new WPI_TalonFX(leftFrontPort);
        this.leftRear = new WPI_TalonFX(leftRearPort);
        this.rightFront = new WPI_TalonFX(rightFrontPort);
        this.rightRear = new WPI_TalonFX(rightRearPort);
        if(RobotMap.driveBaseBreakMode){
            leftFront.setNeutralMode(NeutralMode.Brake);
            rightFront.setNeutralMode(NeutralMode.Brake);
            leftRear.setNeutralMode(NeutralMode.Brake);
            rightRear.setNeutralMode(NeutralMode.Brake);
        } else {
            leftFront.setNeutralMode(NeutralMode.Coast);
            rightFront.setNeutralMode(NeutralMode.Coast);
            leftRear.setNeutralMode(NeutralMode.Coast);
            rightRear.setNeutralMode(NeutralMode.Coast);
        }
        
        leftFront.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 40, 40, .5));
        leftFront.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 40, 40, .5));
        rightFront.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 40, 40, .5));
        rightFront.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 40, 40, .5));
        leftRear.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 40, 40, .5));
        leftRear.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 40, 40, .5));
        rightRear.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 40, 40, .5));
        rightRear.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 40, 40, .5));

        this.leftSide = new MotorControllerGroup(leftFront, leftRear);
        leftSide.setInverted(true);
        this.rightSide = new MotorControllerGroup(rightFront, rightRear);
        this.gyro = new ADXRS450_Gyro(kGyroPort);
    }

    public double getLeftPosition() {
        return leftFront.getSelectedSensorPosition(0) - leftMotorTicks;
    }

    public double getRightPosition() {
        return rightFront.getSelectedSensorPosition(0) - rightMotorTicks;
    }

    public double getGyroAngle() {
        return gyro.getAngle();
    }

    public void zeroEncoderPosition() {
        leftMotorTicks = leftFront.getSelectedSensorPosition(0);
        rightMotorTicks = rightFront.getSelectedSensorPosition(0);
    }

    public void toggleBrakeMode(boolean brakeMode){
        if(brakeMode){
            leftFront.setNeutralMode(NeutralMode.Brake);
            rightFront.setNeutralMode(NeutralMode.Brake);
            leftRear.setNeutralMode(NeutralMode.Brake);
            rightRear.setNeutralMode(NeutralMode.Brake);
        } else {
            leftFront.setNeutralMode(NeutralMode.Coast);
            rightFront.setNeutralMode(NeutralMode.Coast);
            leftRear.setNeutralMode(NeutralMode.Coast);
            rightRear.setNeutralMode(NeutralMode.Coast);
        }
    }

    public void zeroGyroAngle() {
        gyro.reset();
    }
}