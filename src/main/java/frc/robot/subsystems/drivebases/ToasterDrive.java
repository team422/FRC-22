// package frc.robot.subsystems.drivebases;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.SPI;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// public class ToasterDrive extends DriveBase {
//     private static final int leftMiddlePort = 2;
//     private static final int leftFrontPort = 3;
//     private static final int leftRearPort = 6;

//     private static final int rightMiddlePort = 14;
//     private static final int rightFrontPort = 5;
//     private static final int rightRearPort = 4;

//     private WPI_TalonSRX leftMiddle;
//     private WPI_TalonSRX leftFront;
//     private WPI_TalonSRX leftRear;

//     private WPI_TalonSRX rightMiddle;
//     private WPI_TalonSRX rightFront;
//     private WPI_TalonSRX rightRear;

//     private ADXRS450_Gyro gyro;
//     private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;
        
//     public ToasterDrive() {
//         this.leftMiddle = new WPI_TalonSRX(leftMiddlePort);
//         this.leftFront = new WPI_TalonSRX(leftFrontPort);
//         this.leftRear = new WPI_TalonSRX(leftRearPort);

//         leftMiddle.setInverted(true);
//         leftFront.setInverted(true);
//         leftRear.setInverted(true);

//         this.rightMiddle = new WPI_TalonSRX(rightMiddlePort);
//         this.rightFront = new WPI_TalonSRX(rightFrontPort);
//         this.rightRear = new WPI_TalonSRX(rightRearPort);

//         this.leftSide = new MotorControllerGroup(leftMiddle, leftFront, leftRear);
//         this.rightSide = new MotorControllerGroup(rightMiddle, rightFront, rightRear);

//         this.gyro = new ADXRS450_Gyro(kGyroPort);
//     }

//     public double getLeftPosition() {
//         return leftMiddle.getSelectedSensorPosition(0) - leftMotorTicks;
//     }

//     public double getRightPosition() {
//         return rightMiddle.getSelectedSensorPosition(0) - rightMotorTicks;
//     }

//     public double getGyroAngle() {
//         return gyro.getAngle();
//     }

//     public void zeroEncoderPosition() {
//         leftMotorTicks = leftMiddle.getSelectedSensorPosition(0);
//         rightMotorTicks = rightMiddle.getSelectedSensorPosition(0);
//     }

//     public void zeroGyroAngle() {
//         gyro.reset();
//     }
// }
