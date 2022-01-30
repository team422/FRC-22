package frc.robot.subsystems.drivebases;

import frc.robot.subsystems.DriveBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

public class FalconDrive extends DriveBase {
    private WPI_TalonFX leftFront;
    private WPI_TalonFX leftBack;
    private WPI_TalonFX rightFront;
    private WPI_TalonFX rightBack;

    private ADXRS450_Gyro gyro;
    private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;

    public FalconDrive() {
        this.leftFront = new WPI_TalonFX(422);
        this.leftBack = new WPI_TalonFX(422);
        this.rightFront = new WPI_TalonFX(422);
        this.rightBack = new WPI_TalonFX(422);

        this.gyro = new ADXRS450_Gyro(kGyroPort);
    }
    
    public void zeroGyroAngle(){
        
    }

    public void zeroEncoderPosition(){}

    public double getGyroAngle(){
        return gyro.getAngle();
    }

    public double getLeftPosition() {
        return leftFront.getSelectedSensorPosition(0) - leftMotorTicks;
    }

    public double getRightPosition() {
        return rightFront.getSelectedSensorPosition(0) - rightMotorTicks;
    }
}
