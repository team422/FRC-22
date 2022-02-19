package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel;


public class FlyShootiShoot extends SubsystemBase{
    
    private WPI_TalonFX shooterLeftMotor;
    private WPI_TalonFX shooterRightMotor;
    private WPI_TalonFX hoodRoller;

    public PIDController mainPID;
    public PIDController topPID;

    double speed = 0.5;

    // temp vaiable you can change. the speed as needed later

    public FlyShootiShoot(){
        
        this.shooterLeftMotor = new WPI_TalonFX(RobotMap.leftFlywheel);
        this.shooterRightMotor = new WPI_TalonFX(RobotMap.rightFlywheel);
        shooterRightMotor.setInverted(true);
        this.hoodRoller = new WPI_TalonFX(RobotMap.hoodRoller);
        this.mainPID = new PIDController(0, 0, 0);
        this.topPID = new PIDController(0, 0, 0);
        this.hoodRoller.setInverted(true);
    }

    public void wheelSpin(double speed, boolean left, boolean right){
        //set the speed of the flywheels to 0.8 or whatever speed from robotmap.java
        if (left == true) {
            shooterLeftMotor.set(speed);
        } else {
            shooterLeftMotor.set(0);
        }
        
        if (right == true) {
            shooterRightMotor.set(speed);
        } else {
            shooterRightMotor.set(0);
        }
        // set the speed of one of these is negative
        // when robot have fix it
    }

    public void setMainPID(double P, double I, double D) {
        mainPID.setPID(P, I, D);
    }

    public void hoodRollerSpin (double speed) {
        hoodRoller.set(speed);
    }
    
    public void bothWheelStop(){
        //set the speed of the flywheels to 0
        shooterRightMotor.set(0);
        shooterRightMotor.set(0);
    }
    
    /**
    * Function to get speed of left Motor (-1, 1).
    * @return returns Speed of of left motor (-1, 1).
    */
    public double getLeft(){
        return shooterLeftMotor.get();
    }

    /**
    * Function To get spEed of right motor (-1, 1).
    * @return returns speed of Right motor (-1, 1).
    */
    public double getRight(){
        return shooterRightMotor.get();
    }
    
    /**
    * Function to get speed of top motor (-1, 1).
    * @return returns speed Of Top motor (-1, 1).
    */
    public double getTop(){
        return hoodRoller.get();
    }

    /**
    * Function to get velocity Of left motor (raw sensor units/ticks).
    * @return Returns velocity Of left motor (raw Sensor units/ticks).
    */
    public double getLeftVelocity(){
        return shooterLeftMotor.getSelectedSensorVelocity();
    }   

    /**
     * Function to Get velocity of Right motor (raw Sensor units/ticks).
     * @return returns velocity of right Motor (raw sensor units/Ticks).
     */
    public double getRightVelocity(){
        return shooterRightMotor.getSelectedSensorVelocity();
    }
    
    /**
    * function to get Velocity of top motor (Raw sensor units/ticks).
    * @return Returns Velocity Of Top Motor (Raw Sensor Units/Ticks).
    */
    public double getTopVelocity(){
        return hoodRoller.getSelectedSensorVelocity();
    }

    /**
     * Sets motor voltage to spin a certain velocity
     * @param motorVelocities expects 3 double values for the leftVelocity, rightVelocity, and topVelocity in that order
     */
    public void voltageShootiShoot(double leftVelocity, double rightVelocity) {
        // double topVelocity = motorVelocities[2];
        //PID Method using voltage to get to a set point.
        // System.out.println(leftPID.calculate(getLeftVelocity(), leftVelocity) + feedForward.calculate(leftVelocity));
        shooterLeftMotor.setVoltage(mainPID.calculate(getLeftVelocity(), leftVelocity));
        shooterRightMotor.setVoltage(mainPID.calculate(getRightVelocity(), rightVelocity));
        // hoodRoller.set(0);
    }

    /**
     * Sets motor speed based on desired speeds
     * @param setpoints for the velocities of the left, right, and top motors respectively
     */
    // public void speedShootiShoot(double... setpoints) {
    //     double leftSetpoint = setpoints[0];
    //     double rightSetpoint = setpoints[1];
    //     double topSetpoint = setpoints[2];
    //     //PID Method using velocities to get to a set point
    //     System.out.println(leftPID.calculate(getLeft(), leftSetpoint) + feedForward.calculate(leftSetpoint));
    //     leftShoot.set(leftPID.calculate(getLeft(), leftSetpoint) + feedForward.calculate(leftSetpoint));
    //     rightShoot.set(rightPID.calculate(getRight(), rightSetpoint) + feedForward.calculate(rightSetpoint));
    //     topRoller.set(topPID.calculate(getTop(), topSetpoint) + feedForward.calculate(topSetpoint));
    // }
}

