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
        addRequirements(Subsystems.intake, Subsystems.flyShootiShoot, Subsystems.cellStoppiStop, Subsystems.transversal);
    }


    //wpilib looks for initialize, execute, and end!

    public void initialize() {    
        // Subsystems.flyShootiShoot.bothWheelSpin(outtakespeed);
    }

    public void execute() {
        
        /* This is necessary for WPILIB */
        Subsystems.intake.setSucc(outtakespeed); 
        // Subsystems.flyShootiShoot.bothWheelSpin(outtakespeed);
        Subsystems.transversal.setTransversalSpeed(outtakespeed);
        Subsystems.cellStoppiStop.setStoppiStop(outtakespeed);
    }

    public void end() {
        Subsystems.intake.stopSucc();
        Subsystems.flyShootiShoot.bothWheelStop();
        Subsystems.transversal.stopTransversal();
        Subsystems.cellStoppiStop.stopStoppiStop();
    }
    
    
    public boolean isFinished() {
        return true; 
    }
    
}

