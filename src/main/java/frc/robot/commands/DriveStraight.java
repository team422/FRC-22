package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.userinterface.*;
/*
This is the AUTO command to drive straight.
Syntax:
new DriveStraight(speed, time);
speed: velocity of the motors, between -1 and 1 (negative values move backwards)
time: the time in seconds that the command should run
*/


public class DriveStraight extends CommandBase {
    private double speed; //remember types exist lol
    public double inchestraveled; // in inches
    public double inches;
    private int ticks;
    public double angle;
    
    public DriveStraight(double Speed, double inches) {
        setName("DriveStraight");
        addRequirements(Subsystems.driveBase);
        this.speed = Speed;
        this.inches = inches;
    }

    public void initialize() {
        Subsystems.driveBase.zeroGyroAngle();
    }
 
    public void execute() {
        // sets both right and left motor 
        Subsystems.driveBase.setMotors(this.speed, this.speed);
        angle = Subsystems.driveBase.gyro.getAngle();
        // this.ticks += 1;
         
    }

    public void end () {
        Subsystems.driveBase.stopMotors();
    }

    public boolean isFinished() {
        // if (this.time <= (ticks/.02)){
        //     return false;
        // }
        // else {
        //     return true;
        // }
        return true;
    }
}