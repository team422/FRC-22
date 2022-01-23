package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;

public class RetractClimber extends CommandBase {


    public RetractClimber() {
        setName("RetractClimber");
        addRequirements(Subsystems.climber); 
    }

    //wpilib looks for initialize, execute, and end!

    public void initialize() {

    }
    
    public void end () {
        Subsystems.climber.stopClimberBoth();
    }
    
    //speed is set in Climber.java!
    public void execute() {
        Subsystems.climber.climberRetractBoth();
    }

    //allows it to stop automatically once it is finished!
    public boolean isFinished() {
        return true;
    }
}