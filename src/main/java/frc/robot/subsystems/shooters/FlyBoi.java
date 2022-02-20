package frc.robot.subsystems.shooters;

import frc.robot.RobotMap;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class FlyBoi extends BaseShooter {

    // For BangBangController, need velocity of current motor and the desired velocity
    // https://first.wpi.edu/wpilib/allwpilib/docs/release/java/edu/wpi/first/math/controller/BangBangController.html#getSetpoint()
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/bang-bang.html

    WPI_TalonFX leftShoot;
    WPI_TalonFX rightShoot;
    WPI_TalonFX topRoller;
    SimpleMotorFeedforward feedForward;
    PIDController mainPID;
    PIDController topPID;
    
    public FlyBoi(){
        setSubsystem("FlyBoi");
        this.leftShoot = new WPI_TalonFX(RobotMap.leftFlyPort);
        this.rightShoot = new WPI_TalonFX(RobotMap.rightFlyPort);
        this.topRoller = new WPI_TalonFX(RobotMap.flyRolliRoll);
        this.feedForward = new SimpleMotorFeedforward(RobotMap.FlykS, RobotMap.FlykV);
        this.mainPID = new PIDController(RobotMap.FlykP, RobotMap.FlykI, RobotMap.FlykD);
        this.topPID = new PIDController(RobotMap.HoodFlykP, RobotMap.HoodFlykI, RobotMap.HoodFlykD);
    }


    /**
    * Function to set the shoot speed (-1, 1)
    * @param mainSpeed speed to set left and right roller (-1, 1)
    * @param topSpeed speed for the top (-1, 1)
    */
    public void setShootSpeed(double mainSpeed, double topSpeed){
        mainPID.setSetpoint(mainSpeed);
        topPID.setSetpoint(topSpeed);
        leftShoot.set(mainPID.calculate(getLeftVelocity()));
        rightShoot.set(-mainPID.calculate(-getRightVelocity()));
        topRoller.set(topSpeed);
    }

    public void setMainPID(double P, double I, double D) {
        mainPID.setPID(P, I, D);
    }
    
    /**
    * Function to stop the shooter.
    */
    public void stopShoot(){
        leftShoot.stopMotor();
        rightShoot.stopMotor();
        topRoller.stopMotor();
    }
    
    /**
    * Function to get speed of left Motor (-1, 1).
    * @return returns Speed of of left motor (-1, 1).
    */
    public double getLeft(){
        return leftShoot.get();
    }

    /**
    * Function To get spEed of right motor (-1, 1).
    * @return returns speed of Right motor (-1, 1).
    */
    public double getRight(){
        return rightShoot.get();
    }
    
    /**
    * Function to get speed of top motor (-1, 1).
    * @return returns speed Of Top motor (-1, 1).
    */
    public double getTop(){
        return topRoller.get();
    }

    /**
    * Function to get velocity Of left motor (raw sensor units/ticks).
    * @return Returns velocity Of left motor (raw Sensor units/ticks).
    */
    public double getLeftVelocity(){
        return leftShoot.getSelectedSensorVelocity();
    }   

    /**
     * Function to Get velocity of Right motor (raw Sensor units/ticks).
     * @return returns velocity of right Motor (raw sensor units/Ticks).
     */
    public double getRightVelocity(){
        return rightShoot.getSelectedSensorVelocity();
    }

    public double getAverageVelocity() {
        return (getLeftVelocity() + getRightVelocity()) / 2;
    }
    
    /**
    * function to get Velocity of top motor (Raw sensor units/ticks).
    * @return Returns Velocity Of Top Motor (Raw Sensor Units/Ticks).
    */
    public double getTopVelocity(){
        return topRoller.getSelectedSensorVelocity();
    }

    /**
     * Sets motor voltage to spin a certain velocity
     * @param motorVelocities expects 3 double values for the leftVelocity, rightVelocity, and topVelocity in that order
     */
    @Override
    public void voltageShootiShoot(double leftVelocity, double rightVelocity, double topVelocity) {
        //PID Method using voltage to get to a set point.
        System.out.println(mainPID.calculate(getLeftVelocity(), leftVelocity) + feedForward.calculate(leftVelocity));
        leftShoot.setVoltage(mainPID.calculate(getLeftVelocity(), leftVelocity) + feedForward.calculate(leftVelocity));
        rightShoot.setVoltage(mainPID.calculate(getRightVelocity(), rightVelocity) + feedForward.calculate(rightVelocity));
        // topRoller.setVoltage(topPID.calculate(getTopVelocity(), topVelocity) + feedForward.calculate(topVelocity));
        topRoller.set(topVelocity);
    }

    /**
     * Sets motor speed based on desired speeds
     * @param setpoints for the velocities of the left, right, and top motors respectively
     */
    @Override
    public void speedShootiShoot(double... setpoints) {
        double leftSetpoint = setpoints[0];
        double rightSetpoint = setpoints[1];
        double topSetpoint = setpoints[2];
        //PID Method using velocities to get to a set point
        System.out.println(mainPID.calculate(getLeft(), leftSetpoint) + feedForward.calculate(leftSetpoint));
        leftShoot.set(mainPID.calculate(getLeft(), leftSetpoint) + feedForward.calculate(leftSetpoint));
        rightShoot.set(mainPID.calculate(getRight(), rightSetpoint) + feedForward.calculate(rightSetpoint));
        topRoller.set(topPID.calculate(getTop(), topSetpoint) + feedForward.calculate(topSetpoint));
    }


}