package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeStop extends CommandBase {
    public IntakeStop() {
        setName("IntakeStop");
        addRequirements(Subsystems.intake);
    }


    //wpilib looks for initialize, execute, and end!
    public void initialize() {
        Subsystem.intake.stopSucc();
    }

    public boolean isFinished() {
        return true;
    }
}