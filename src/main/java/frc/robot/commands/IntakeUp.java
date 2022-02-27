package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.userinterface.UserInterface;

public class IntakeUp extends CommandBase {

    /*
    command to control the upDown motor on the intake!
    */
    public IntakeUp() {
        setName("IntakeUp");
        addRequirements(Subsystems.intake);
    }

    //wpilib looks for initialize, execute, and end!
    public void initialize() {
        Subsystems.intake.engageExtend();
        // if(Subsystems.intake.isIntakeDown) {
            //     Subsystems.intake.engageExtend();
        // } else if(!Subsystems.intake.isIntakeDown) {
        //     Subsystems.intake.retractExtend();
        // }
    }

    public void execute() {
        
    }

    public void end() {
    }

    public boolean isFinished() {
        return true; 
    }
    
}

