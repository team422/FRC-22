package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.userinterface.*;
import frc.robot.subsystems.Subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class ManualShoot extends CommandBase {

    public double lastShooterSpeed;

    public ManualShoot(){
        setName("ShootBall");
        addRequirements(Subsystems.flyBoi, Subsystems.cellStop, Subsystems.transversal);
    }

    @Override
    public void initialize(){
        lastShooterSpeed = 0;
    }

    // just checks if any two given values r in a range! :)
    
    @Override
    public void execute() {
        
        Subsystems.flyBoi.setShootSpeed(RobotMap.leftVelocity, RobotMap.topVelocity);
    }

    public void end(){
        Subsystems.flyBoi.stopShoot();
    }
    
    @Override
    public boolean isFinished() {
        //if there are no balls then don't shoot.
        return true;
    }

}
