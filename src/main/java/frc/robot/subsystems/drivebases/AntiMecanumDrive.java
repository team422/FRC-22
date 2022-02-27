// package frc.robot.subsystems.drivebases;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.SPI;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// public class AntiMecanumDrive extends DriveBase {
//     private static final int leftFrontPort = 422;
//     private static final int leftRearPort = 422;
//     private static final int rightFrontPort = 422;
//     private static final int rightRearPort = 422;

//     private WPI_TalonSRX leftFront;
//     private WPI_TalonSRX leftRear;
//     private WPI_TalonSRX rightFront;
//     private WPI_TalonSRX rightRear;

//     private ADXRS450_Gyro gyro;
//     private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;
        
//     public AntiMecanumDrive() {
//         this.leftFront = new WPI_TalonSRX(leftFrontPort);
//         this.leftRear = new WPI_TalonSRX(leftRearPort);
//         this.rightFront = new WPI_TalonSRX(rightFrontPort);
//         this.rightRear = new WPI_TalonSRX(rightRearPort);

//         this.leftSide = new MotorControllerGroup(leftFront, leftRear);
//         this.rightSide = new MotorControllerGroup(rightFront, rightRear);

//         this.gyro = new ADXRS450_Gyro(kGyroPort);
//     }

//     public double getLeftPosition() {
//         return leftFront.getSelectedSensorPosition(0) - leftMotorTicks;
//     }

//     public double getRightPosition() {
//         return rightFront.getSelectedSensorPosition(0) - rightMotorTicks;
//     }

//     public double getGyroAngle() {
//         return gyro.getAngle();
//     }

//     public void zeroEncoderPosition() {
//         leftMotorTicks = leftFront.getSelectedSensorPosition(0);
//         rightMotorTicks = rightFront.getSelectedSensorPosition(0);
//     }

//     public void zeroGyroAngle() {
//         gyro.reset();
//     }
// }
