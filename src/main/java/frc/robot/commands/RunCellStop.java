package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunCellStop extends CommandBase{
    public RunCellStop() {
        setName("RunCellStop");
        addRequirements(Subsystems.cellStop);
    }

    //wpilib looks for initialize, execute, and end!
    public void initialize() {
        Subsystems.cellStop.setStop(-0.4);
    }

    public void execute() {
        
    }

    public void end() {
    }

    public boolean isFinished() {
        return true; 
    }
}
