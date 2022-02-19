package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class FalconDrive extends DriveBase {
    private static final int leftFrontPort = 4;
    private static final int leftRearPort = 2;
    private static final int rightFrontPort = 3;
    private static final int rightRearPort = 1;

    private WPI_TalonFX leftFront;
    private WPI_TalonFX leftRear;
    private WPI_TalonFX rightFront;
    private WPI_TalonFX rightRear;

    private ADXRS450_Gyro gyro;
    private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;

    public FalconDrive() {
        this.leftFront = new WPI_TalonFX(leftFrontPort);
        this.leftRear = new WPI_TalonFX(leftRearPort);
        this.rightFront = new WPI_TalonFX(rightFrontPort);
        this.rightRear = new WPI_TalonFX(rightRearPort);

        this.leftSide = new MotorControllerGroup(leftFront, rightFront);
        this.rightSide = new MotorControllerGroup(leftRear, rightRear);
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

    public void zeroGyroAngle() {
        gyro.reset();
    }
}