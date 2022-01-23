package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Transversal extends SubsystemBase{
    public WPI_TalonSRX motor1;
    public WPI_TalonSRX motor2;
    
    // POSSIBLY NOT USING TALONS ON THIS PART
    // THIS COULD BE VICTORS
    public Transversal(){
        setSubsystem("Transversal");
        // int deviceNumber = 10; // This is currently a random 
    }

    public void setTransversalSpeed (double speed){
        motor1.set(speed);
        motor2.set(speed);
    }
    public void stopTransversal(){
        motor1.set(0);
        motor2.set(0);
    }
}