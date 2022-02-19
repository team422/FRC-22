package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendClimber extends CommandBase {
    /*
    command to extend the climber!
    */
    public ExtendClimber() {
        setName("ExtendClimber");
        addRequirements(Subsystems.climber);
    }


    //wpilib looks for initialize, execute, and end!
    public void initialize() {

    }
    
    public void execute() {
        Subsystems.climber.climberExtendBoth();
    }
    
    public void end () {
        Subsystems.climber.stopClimberBoth();
    }
    

    //wpilib looks for this to automattically end the command
    public boolean isFinished() {
        return true;
    }
}