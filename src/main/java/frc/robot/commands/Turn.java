//Imporrts
package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.userinterface.*;
/*
AUTO turn
Syntax:
new Turn(turn, speed)
turn - amount to turn in degrees. positive is right, negative is left.
speed - b/w 0 and 1, used as the speed for the motors. if you put in a negative we'll take absolute value.
*/

public class Turn extends CommandBase{
    private int turn; //amount to turn
    private double turned; // amount already turned
    private double speed; // speed of turn (between -1 and 1)
    
    
    public Turn(int uTurn, double uSpeed) {
        setName("Turn");
        addRequirements(Subsystems.driveBase);
        this.speed = Math.abs(uSpeed);
        this.turn = uTurn; 

    }


    public void initialize() {
        Subsystems.driveBase.setMotors(this.speed, this.speed);
        Subsystems.driveBase.zeroGyroAngle();
    }
    
    public void end () {
        Subsystems.driveBase.stopMotors();
    }

    public void execute() {
        //figure out how to turn the approprate amount
        this.turned = Subsystems.driveBase.getGyroAngle();
        Subsystems.driveBase.setLeftMotors(this.speed*Integer.signum(this.turn));
        Subsystems.driveBase.setRightMotors(-1*this.speed*Integer.signum(this.turn));
    }

    public boolean isFinished() {
        if (Math.abs(this.turn) < Math.abs(this.turned)) {
            return false;
        }
        else {
            return true;
        }
    } 
}
