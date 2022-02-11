package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.lang.Math;

public class TankDrive extends CommandBase{

    public double leftSpeed;
    public double rightSpeed;
    public double leftLastSpeed;
    public double rightLastSpeed;
    public double leftSpeedDiff;
    public double rightSpeedDiff;

    // public double accelSens = 5; //sensitivity for acceleration
    // public double minAccel; // smallest amount needed for object to move, not really needed but cool to have 
    public double maxAccel = 0.5; // maximum acceleration before it caps out

    public TankDrive(){
        setName("TankDrive");
        addRequirements(Subsystems.driveBase);

        this.leftSpeed = 0;
        this.rightSpeed = 0;
        this.leftLastSpeed = 0;
        this.rightLastSpeed = 0;
        this.leftSpeedDiff = 0;
        this.rightSpeedDiff = 0;
    }

    public void execute(){
        leftSpeed = UserInterface.driverController.getLeftJoystickY();
        rightSpeed = UserInterface.driverController.getRightJoystickY();
        
        // System.out.println(leftSpeed);
        // System.out.println(rightSpeed);
        // System.out.println("break");

        // minimium speed is the same for any speed cap right now, but if placed under conditionals, then different
        leftSpeed *= RobotMap.getSpeedCap(); // THIS MIGHT BE WRONG
        rightSpeed *= RobotMap.getSpeedCap();
        // leftSpeed *= RobotMap.speedCap;
        // rightSpeed *= RobotMap.speedCap;
        
        if(Math.abs(leftSpeed) < 0.1){
            leftSpeed = 0;
        }

        if(Math.abs(rightSpeed) < 0.1){
            rightSpeed = 0;
        }

        leftSpeedDiff = leftSpeed - leftLastSpeed;
        rightSpeedDiff = rightSpeed - rightLastSpeed;
        
        // // Old acceleration cap basically checked if the speed was over the max change distance,
        // // but I wanted to make just one equationto do that, hence the following:
        // // Needs more work (doesn't work so don't uncomment without fixing)
        // // leftSpeed = leftLastSpeed + (Math.exp(((-1)*accelSens*leftSpeedDiff)-0.7) + maxAccel);
        // // rightSpeed = rightLastSpeed + (Math.exp(((-1)*accelSens*rightSpeedDiff)-0.7) + maxAccel);

        // // Old acceleration but with a ternary operator to simplify it
        leftSpeed = Math.abs(leftSpeedDiff) > maxAccel ? leftLastSpeed + Math.signum(leftSpeedDiff)*maxAccel : leftSpeed;
        rightSpeed = Math.abs(rightSpeedDiff) > maxAccel ? rightLastSpeed + Math.signum(rightSpeedDiff)*maxAccel : rightSpeed;

        leftLastSpeed = leftSpeed;
        rightLastSpeed = rightSpeed;

        System.out.println(leftSpeed);
        Subsystems.driveBase.cheesyDrive.tankDrive(-leftSpeed, -rightSpeed);
    }

}
