package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;

/* 
Hi. This is the Intake. You would know this from the title.
*/

public class Intake extends SubsystemBase {
    public WPI_TalonSRX succMotor; //intake motor
    public WPI_TalonSRX upyDownyMotor; 

    
    public Intake() {
        setSubsystem("Intake");
        this.succMotor = new WPI_TalonSRX(RobotMap.succMotor);
        this.upyDownyMotor = new WPI_TalonSRX(RobotMap.upyDownyMotor);
    } 
    
    public void setSucc(double speed) {
        succMotor.set(speed);
    }

    public void setUpDown(double speed){
        upyDownyMotor.set(speed);
    }

    public void stopSucc () {
        succMotor.set(0);
    }

    public void stopUpDown () {
        upyDownyMotor.set(0);
    }

}
