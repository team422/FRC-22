package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeIn extends CommandBase {
    public IntakeIn() {
        setName("IntakeIn");
        addRequirements(Subsystems.intake, Subsystems.transversal, Subsystems.cellStop);
    }


    //wpilib looks for initialize, execute, and end!
    public void initialize() {

    }

    
    public void execute() {
        Subsystems.intake.engageIntake(0.5);
        Subsystems.transversal.setTransversalSpeed(0.5);
        Subsystems.cellStop.setStop(0.5);
    }

    public boolean isFinished() {
        return true;
    }
}
