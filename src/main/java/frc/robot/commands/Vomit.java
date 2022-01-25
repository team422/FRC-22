package frc.robot.commands;

import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.userinterface.UserInterface;


public class Vomit extends CommandBase {

    public double angle = 0;
    private double outtakespeed = -0.6;
    
    //runs intake in either direction depending on left joystick!

    public Vomit() {
        setName("Vomit");
        addRequirements(Subsystems.intake, Subsystems.flyBoi, Subsystems.cellStop, Subsystems.transversal);
    }


    //wpilib looks for initialize, execute, and end!

    public void initialize() {    
        // Subsystems.flyShootiShoot.bothWheelSpin(outtakespeed);
    }

    public void execute() {
        
        /* This is necessary for WPILIB */
        Subsystems.intake.setSucc(outtakespeed); 
        Subsystems.flyBoi.bothWheelSpin(outtakespeed);
        Subsystems.transversal.setTransversalSpeed(outtakespeed);
        Subsystems.cellStop.setStoppiStop(outtakespeed);
    }

    public void end() {
        Subsystems.intake.stopSucc();
        Subsystems.flyBoi.bothWheelStop();
        Subsystems.transversal.stopTransversal();
        Subsystems.cellStop.stopStoppiStop();
    }
    
    
    public boolean isFinished() {
        return true; 
    }
    
}

