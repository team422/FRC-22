package frc.robot.subsystems;
// import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Transversal extends SubsystemBase{
    public CANSparkMax lefttransversalMotor;
    public CANSparkMax righttransversalMotor;
    
    // POSSIBLY NOT USING TALONS ON THIS PART
    // THIS COULD BE VICTORS

    //LMAO JK ITS NEOS KILL MEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE - Aaron
    public Transversal(){
        setSubsystem("Transversal");
        this.righttransversalMotor = new CANSparkMax(RobotMap.righttransversalPort, CANSparkMaxLowLevel.MotorType.kBrushless);
        // this.righttransversalMotor.setInverted(true);
        this.lefttransversalMotor = new CANSparkMax(RobotMap.lefttransversalPort, CANSparkMaxLowLevel.MotorType.kBrushless);

    }

    public void setTransversalSpeed (double speed){
        lefttransversalMotor.set(speed);
        righttransversalMotor.set(-speed);
    }
    public void stopTransversal(){
        lefttransversalMotor.stopMotor();
        righttransversalMotor.stopMotor();
    }
}