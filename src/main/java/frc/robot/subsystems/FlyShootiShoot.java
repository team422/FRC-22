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
            mainPID.setSetpoint(speed);
            shooterLeftMotor.set(mainPID.calculate(getVelocity()));
        } else {
            mainPID.setSetpoint(0);
            shooterLeftMotor.set(mainPID.calculate(getVelocity()));
        }
        
        if (right == true) {
            mainPID.setSetpoint(speed);
            shooterLeftMotor.set(mainPID.calculate(getVelocity()));
        } else {
            mainPID.setSetpoint(0);
            shooterLeftMotor.set(mainPID.calculate(getVelocity()));
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

    public double getVelocity () {
        return (shooterLeftMotor.getSelectedSensorVelocity() + shooterRightMotor.getSelectedSensorVelocity()) / 2;
    }

    // Fun Fact: Neos are conncted in order to double the power, so below does not work
    // DONT EVEN TRY TO USE IT
    // You've been warned

    // Hey there, justing testing if you can change the shooting angle (left and right) of the ball - yash
    // also, I'm bored
    // For the Future: experiment with speeds of the flywheels (left and right) by changing the relative speed of both
    // If one flywheel has a higher speed than the other, then the ball will fly in a certain direction
    // flywheels to make the robot able to launch the balls at an angle
    // Visualization:
    // . . . . . . . . 
    //   . . . . . .
    //     . . . .
    //       ...
    //        .
    //       -ˆ-
    //      |   | 
    //       ---

    /*public void ballAngleShoot(double speed, double angle){
        // set the speed of one of these is negative
        // when robot have fix it because we dont want to suck the ball in when trying to shoot it

        double adjustedangle;
        double otherwheeladjustedangle;

        // is the relationship between the angle of shooting and flywheel speed linear, quadratic or something else?
        // not currently known will test when given robot - yash
        // going to assume that its linear and that left motor need -speed and right motor needs speed to shoot the ball out. might be wrong

        // going to try a linear relationship
        // angle in degrees between 0 and 180 where 0 is the positive x axis and 180 is the negative x axis

        if (angle < 90){
            adjustedangle = angle/90;
            otherwheeladjustedangle = (angle-90)/90;
            shooterLeftMotor.set(adjustedangle);
            shooterRightMotor.set(otherwheeladjustedangle);
        } else if (angle > 90){
            adjustedangle = (angle-90)/90;
            otherwheeladjustedangle = (angle-180)/90;
            shooterLeftMotor.set(otherwheeladjustedangle);
            shooterRightMotor.set(adjustedangle);
        } else if (angle = 90){
            shooterLeftMotor.set(-speed);
            shooterRightMotor.set(speed);
        }

        shooterRightMotor.set(0);
        shooterRightMotor.set(0);
        */
    // }

}

