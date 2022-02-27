package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;


public class ManualStopShoot extends CommandBase {

    public double lastShooterSpeed;

    public ManualStopShoot(){
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
        Subsystems.flyBoi.stopShoot();
        
    }
    
    @Override
    public boolean isFinished() {
        //if there are no balls then don't shoot.
        return true;
    }

}
