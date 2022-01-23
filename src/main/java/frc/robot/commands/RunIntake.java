package frc.robot.commands;

import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.userinterface.UserInterface;


public class RunIntake extends CommandBase {

    public double angle = 0;

    //runs intake in either direction depending on left joystick!

    public RunIntake() {
        setName("RunIntake");
        addRequirements(Subsystems.intake);
    }


    //wpilib looks for initialize, execute, and end!

    public void initialize() {
    }

    public void execute() {
        
        /* This is necessary for WPILIB */
        Subsystems.intake.setSucc(UserInterface.operatorController.getLeftJoystickY()); 

        
    }

    public void end() {
        Subsystems.intake.stopSucc();
    }

    //allows it to stop automatically once it is finished
    // is also necessary for WPILIB
    public boolean isFinished() {
        return true; 
    }
    
}

