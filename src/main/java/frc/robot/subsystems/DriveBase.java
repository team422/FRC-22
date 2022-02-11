//  THINGS TO REMEMBER:
//  If a function is not labeled to do so it should not be able to do things to the outside world like print stuff, log stuff, and change robot values
//  Paramaters of each method and function should be labeled in a comment as well as what the function does
//  Write what the output of a function will be and exactly how it will be

package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.TalonFX;
// import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import com.analog.adis16470.frc.ADIS16470_IMU;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * The drive base of the robot. Includes all drive train motor controllers as well as sensors such as gyros and encoders, and can use PID to set its motor speeds.
 * This has been copied from the old code base and changes will be 
 */
public class DriveBase extends SubsystemBase {

    // Creating variables for motors
    public WPI_TalonFX leftLeader; // leader = front
    public WPI_TalonFX rightLeader;
    public WPI_TalonFX leftFollower; // follower = back
    public WPI_TalonFX rightFollower;

    // laptop (driver station) -> robo rio (This is the computer that talks to the laptop, it is on the robot and its a little white thing) -> PDP (red things with lots of lights)  - >  motor controller     ->  motor (Black thing that goes spinny spin next to )

    // Motor Controllers
    public WPI_TalonSRX leftFrontFollowerTalon;
    public WPI_TalonSRX leftRearFollowerTalon;
    public WPI_TalonSRX rightFrontFollowerTalon;
    public WPI_TalonSRX rightRearFollowerTalon;

    public ADXRS450_Gyro gyro;
    private MotorControllerGroup leftSide;
    private MotorControllerGroup rightSide;
    public DifferentialDrive cheesyDrive;
    private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;

    public double leftMotorTicks = 0;
    public double rightMotorTicks = 0;

    public DriveBase() {
        setSubsystem("DriveBase");

        // falcon drivebase (promised but nonexistent as of 10/29/21, how time have not changed) 
        this.leftLeader = new WPI_TalonFX(RobotMap.leftLeader);
        this.rightLeader = new WPI_TalonFX(RobotMap.rightLeader);
        this.leftFollower = new WPI_TalonFX(RobotMap.leftFollower);
        this.rightFollower = new WPI_TalonFX(RobotMap.rightFollower);

        this.leftSide = new MotorControllerGroup(leftLeader, leftFollower);
        this.rightSide = new MotorControllerGroup(rightLeader, rightFollower);

        // this.gyro = new ADIS16470_IMU();
        this.gyro = new ADXRS450_Gyro(kGyroPort);

        leftMotorTicks = leftLeader.getSelectedSensorPosition(0);
        rightMotorTicks = rightLeader.getSelectedSensorPosition(0);

        this.cheesyDrive = new DifferentialDrive(leftSide, rightSide);
    }

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

    /**
     * @return Left side position in ticks. If statement exists because Falcon uses a different motor as leader than 
     * the other drivebases 
     */
    public double getLeftPosition() {
            return leftLeader.getSelectedSensorPosition(0) - leftMotorTicks;
    }

    /**
     * @return Right side position in ticks.
     */
    public double getRightPosition() {
        return rightLeader.getSelectedSensorPosition(0) - rightMotorTicks;
    }

    /**
     * @return Angle at which the robot is positioned in degrees
     */
    public double getGyroAngle() {
        return gyro.getAngle();
    }

    /**
     * Resets the reference point used to calculate distance traveled. Does not physically change the encoder value.
     */
    public void zeroEncoderPosition() {
        leftMotorTicks = leftLeader.getSelectedSensorPosition(0);
        rightMotorTicks = rightLeader.getSelectedSensorPosition(0);
    }

    /**
     * Sets the gyro angle to zero.
     */
    public void zeroGyroAngle() {
        gyro.reset();
    }
}
