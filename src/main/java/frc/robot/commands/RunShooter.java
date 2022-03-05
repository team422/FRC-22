package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.userinterface.*;
import frc.robot.subsystems.Subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class RunShooter extends CommandBase {

    public double flyspeed;
    public double topspeed;
    public double lastShooterSpeed;

    public RunShooter(double flyspeed, double hoodspeed){
        this.flyspeed = flyspeed;
        this.topspeed = hoodspeed;
        setName("ShootBall");
        addRequirements(Subsystems.flyBoi, Subsystems.transversal);
    }

    @Override
    public void initialize(){
        Subsystems.flyBoi.setShootSpeed(flyspeed, topspeed);
    }
    
    @Override
    public void execute() {
    }

    public void end(){
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }

}
