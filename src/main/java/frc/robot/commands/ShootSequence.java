package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.userinterface.UserInterface;

public class ShootSequence extends CommandBase {
    public double Speed = 422.00;
    public double Speedtwo = 422.0;
    public ShootSequence() {
        setName("ShootSequence");
        addRequirements(Subsystems.flyBoi, Subsystems.cellStop, Subsystems.transversal);
    }
    
    public void initialize () {
        Subsystems.flyBoi.Spin(Speed, Speedtwo);
    }
    
    public void execute () {
        if (Subsystems.flyBoi.getVelocity()>=422) {
            Subsystems.cellStop.setStop(0.8);
            Subsystems.transversal.setTransversalSpeed(0.8);    
        } else {
            Subsystems.cellStop.stopStoppiStop();
            Subsystems.transversal.stopTransversal();           
        }
    }

    public boolean isFinished () {
        return true;
    }

    public void end () {
        Subsystems.flyBoi.bothWheelStop();
        Subsystems.cellStop.stopStoppiStop();
        Subsystems.transversal.stopTransversal(); 
    }
}