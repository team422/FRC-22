package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class IntakeIn extends CommandBase {
    public IntakeIn() {
        setName("IntakeIn");
        addRequirements(Subsystems.intake, Subsystems.transversal, Subsystems.cellStop, Subsystems.colourSensor);
    }


    //wpilib looks for initialize, execute, and end!
    public void initialize() {
        Subsystems.intake.engageIntake(0.5);
        Subsystems.transversal.setTransversalSpeed(0.5);
        Subsystems.cellStop.setStop(0.2);
    }

    
    public void execute() {
        Subsystems.intake.engageIntake(0.5);
        Subsystems.transversal.setTransversalSpeed(0.5);
        if(Subsystems.colourSensor.isBallColourGood()) {
            Subsystems.cellStop.setStop(0);
        } else {
            Subsystems.cellStop.setStop(0.4);
        }
    }

    public boolean isFinished() {
        return true;
    }
}
