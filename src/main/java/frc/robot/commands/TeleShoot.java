package frc.robot.commands;
import frc.robot.subsystems.Subsystems;
import frc.robot.subsystems.shooters.FlyBoi;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotMap;
public class TeleShoot extends CommandBase {
    public TeleShoot(){
        setName("TeleShoot");
        addRequirements(Subsystems.flyBoi, Subsystems.cellStop, Subsystems.transversal);
    }
    public void execute(){
        Subsystems.flyBoi.setShootSpeed(RobotMap.leftVelocity, RobotMap.topVelocity);
        Subsystems.cellStop.setStop(.4);
        Subsystems.transversal.setTransversalSpeed(0.4);
    }
    public boolean isFinished(){
        return false;
    }
}
