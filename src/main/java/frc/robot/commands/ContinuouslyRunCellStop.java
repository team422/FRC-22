package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Subsystems;
import edu.wpi.first.wpilibj2.command.WaitCommand;
public class ContinuouslyRunCellStop extends CommandBase{
    public ContinuouslyRunCellStop(){
        setName("ContinouslyRunCellStop");
        addRequirements(Subsystems.cellStop, Subsystems.colourSensor, Subsystems.transversal);
    }
    
    public void execute(){
        if(Subsystems.colourSensor.getProximity() < 160){
            Subsystems.transversal.setTransversalSpeed(0.4);
            Subsystems.cellStop.setStop(0.15);
        }
    }
    public boolean isFinished(){
        return false;
    }
}
