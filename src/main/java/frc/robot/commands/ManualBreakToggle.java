package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.RobotMap;

public class ManualBreakToggle extends CommandBase {

    public ManualBreakToggle() {
        setName("ManualBreakToggle");
        addRequirements(Subsystems.climber); 
    }

    //wpilib looks for initialize, execute, and end!
    @Override
    public void initialize() {

        Subsystems.climber.ClimberBrake.toggle();

    }
    //allows it to stop automatically once it is finished!
    @Override
    public boolean isFinished() {
        return true;
    }
}