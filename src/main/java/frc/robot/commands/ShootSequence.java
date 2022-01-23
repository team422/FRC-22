package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.userinterface.UserInterface;

public class ShootSequence extends CommandBase {
    public double Speed = 422.00;
    public ShootSequence() {
        setName("ShootSequence");
        addRequirements(Subsystems.flyShootiShoot, Subsystems.cellStoppiStop, Subsystems.transversal);
    }
    
    public void initialize () {
        Subsystems.flyShootiShoot.bothWheelSpin(Speed);
    }
    
    public void execute () {
        Subsystems.flyShootiShoot.bothWheelSpin(Speed);
        if (Subsystems.flyShootiShoot.getVelocity()>=422) {
            Subsystems.cellStoppiStop.setStoppiStop(0.8);
            Subsystems.transversal.setTransversalSpeed(0.8);    
        } else {
            Subsystems.cellStoppiStop.stopStoppiStop();
            Subsystems.transversal.stopTransversal();           
        }
    }

    public boolean isFinished () {
        return true;
    }

    public void end () {
        Subsystems.flyShootiShoot.bothWheelStop();
        Subsystems.cellStoppiStop.stopStoppiStop();
        Subsystems.transversal.stopTransversal(); 
    }
}