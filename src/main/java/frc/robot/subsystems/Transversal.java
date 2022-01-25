package frc.robot.subsystems;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

// import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Transversal extends SubsystemBase{
    public CANSparkMax transversalMotor;
    
    // POSSIBLY NOT USING TALONS ON THIS PART
    // THIS COULD BE VICTORS

    //LMAO JK ITS NEOS KILL MEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE - Aaron
    public Transversal(){
        setSubsystem("Transversal");
        this.transversalMotor = new CANSparkMax(RobotMap.transversalMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
    }

    public void setTransversalSpeed (double speed){
        transversalMotor.set(speed);
    }
    public void stopTransversal(){
        transversalMotor.stopMotor();
    }
}