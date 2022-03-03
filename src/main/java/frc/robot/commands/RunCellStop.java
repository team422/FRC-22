package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunCellStop extends CommandBase{
    private double vel = 0;
    public RunCellStop(double speed) {
        this.vel = speed;
        setName("RunCellStop");
        addRequirements(Subsystems.cellStop);
    }

    //wpilib looks for initialize, execute, and end!
    public void initialize() {
        Subsystems.cellStop.setStop(vel);
    }

    public void execute() {
        
    }

    public void end() {
    }

    public boolean isFinished() {
        return true; 
    }
}
