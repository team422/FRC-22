package frc.robot.subsystems.shooters;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import frc.robot.RobotMap;

public class FlyBoi extends BaseShooter {

    // For BangBangController, need velocity of current motor and the desired
    // velocity
    // https://first.wpi.edu/wpilib/allwpilib/docs/release/java/edu/wpi/first/math/controller/BangBangController.html#getSetpoint()
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/bang-bang.html

    WPI_TalonFX leftShoot;
    WPI_TalonFX rightShoot;
    WPI_TalonFX topRoller;
    SimpleMotorFeedforward feedForward;
    PIDController leftPID;
    PIDController rightPID;
    PIDController topPID;

    public FlyBoi() {
        setSubsystem("FlyBoi");
        this.leftShoot = new WPI_TalonFX(RobotMap.leftFlywheel);
        this.rightShoot = new WPI_TalonFX(RobotMap.rightFlywheel);
        leftShoot.setInverted(true);
        this.topRoller = new WPI_TalonFX(RobotMap.topFlyWheel);
        topRoller.setInverted(true);
        this.feedForward = new SimpleMotorFeedforward(RobotMap.FlykS, RobotMap.FlykV, RobotMap.FlykA);
        this.leftPID = new PIDController(0,0,0);
        this.rightPID = new PIDController(0,0,0);
        // this.topPID = new PIDController(RobotMap.HoodFlykP, RobotMap.HoodFlykI,
        // RobotMap.HoodFlykD);
    }

    /**
     * Function to set the shoot speed (-1, 1)
     * 
     * @param mainSpeed speed to set left and right roller (-1, 1)
     * @param topSpeed  speed for the top (-1, 1)
     */
    public void setShootSpeed(double mainSpeed, double topSpeed) {
        leftShoot.set(mainSpeed);
        rightShoot.set(mainSpeed);
        topRoller.set(topSpeed);
    }

    /**
     * Function to stop the shooter.
     */
    public void stopShoot() {
        leftShoot.stopMotor();
        rightShoot.stopMotor();
        topRoller.stopMotor();
    }

    /**
     * Function to get speed of left Motor (-1, 1).
     * 
     * @return returns Speed of of left motor (-1, 1).
     */
    public double getLeft() {
        return leftShoot.get();
    }

    /**
     * Function To get spEed of right motor (-1, 1).
     * 
     * @return returns speed of Right motor (-1, 1).
     */
    public double getRight() {
        return rightShoot.get();
    }

    /**
     * Function to get speed of top motor (-1, 1).
     * 
     * @return returns speed Of Top motor (-1, 1).
     */
    public double getTop() {
        return topRoller.get();
    }

    /**
     * Function to get velocity Of left motor (raw sensor units/ticks).
     * 
     * @return Returns velocity Of left motor (raw Sensor units/ticks).
     */
    public double getLeftVelocity() {
        return leftShoot.getSelectedSensorVelocity();
    }

    /**
     * Function to Get velocity of Right motor (raw Sensor units/ticks).
     * 
     * @return returns velocity of right Motor (raw sensor units/Ticks).
     */
    public double getRightVelocity() {
        return rightShoot.getSelectedSensorVelocity();
    }

    public double getAverageVelocity() {
        return (getLeftVelocity() + getRightVelocity()) / 2;
    }

    /**
     * function to get Velocity of top motor (Raw sensor units/ticks).
     * 
     * @return Returns Velocity Of Top Motor (Raw Sensor Units/Ticks).
     */
    public double getTopVelocity() {
        return topRoller.getSelectedSensorVelocity();
    }

    /**
     * Sets motor voltage to spin a certain velocity
     * 
     * @param motorVelocities expects 3 double values for the leftVelocity,
     *                        rightVelocity, and topVelocity in that order
     */
    public void voltageShootiShoot(double leftVelocity, double rightVelocity, double topVelocity) {
        // PID Method using voltage to get to a set point.
        System.out.println(leftPID.calculate(getLeftVelocity(), leftVelocity) + feedForward.calculate(leftVelocity));
        leftShoot.setVoltage(leftPID.calculate(getLeftVelocity(), leftVelocity) + feedForward.calculate(leftVelocity));
        // rightShoot.setVoltage(rightPID.calculate(getRightVelocity(), rightVelocity) + feedForward.calculate(rightVelocity));
        // topRoller.setVoltage(topPID.calculate(getTopVelocity(), topVelocity) + feedForward.calculate(topVelocity));
    }

    public void setPID(double P, double I, double D){
        System.out.println("Setting P: " + P + " I: " + " D: " + D);
        leftPID.setPID(P, I, D);
        rightPID.setPID(P, I, D);
    }

    /**
     * Sets motor speed based on desired speeds
     * 
     * @param setpoints for the velocities of the left, right, and top motors
     *                  respectively
     */
    @Override
    public void speedShootiShoot(double... setpoints) {
        double leftSetpoint = setpoints[0];
        double rightSetpoint = setpoints[1];
        double topSetpoint = setpoints[2];
        // PID Method using velocities to get to a set point
        System.out.println(leftPID.calculate(getLeft(), leftSetpoint) + feedForward.calculate(leftSetpoint));
        leftShoot.set(leftPID.calculate(getLeft(), leftSetpoint) + feedForward.calculate(leftSetpoint));
        rightShoot.set(rightPID.calculate(getRight(), rightSetpoint) + feedForward.calculate(rightSetpoint));
        topRoller.set(topPID.calculate(getTop(), topSetpoint) + feedForward.calculate(topSetpoint));
    }
}