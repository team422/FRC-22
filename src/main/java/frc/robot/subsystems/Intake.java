package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;

/* 
Hi. This is the Intake. You would know this from the title.
*/

public class Intake extends SubsystemBase {
    public CANSparkMax succMotor; //intake motor
    public WPI_TalonSRX upyDownyMotorRight; 
    public WPI_TalonSRX upyDownyMotorLeft;

    
    public Intake() {
        setSubsystem("Intake");
        this.succMotor = new CANSparkMax(RobotMap.succMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        this.upyDownyMotorRight = new WPI_TalonSRX(RobotMap.upyDownyMotorRight);
        this.upyDownyMotorLeft = new WPI_TalonSRX(RobotMap.upyDownyMotorLeft);
    } 
    
    public void setSucc(double speed) {
        succMotor.set(speed);
    }

    public void setUpDown(double speed){
        upyDownyMotorLeft.set(speed);
        upyDownyMotorLeft.set(-speed);
    }

    public void stopSucc () {
        succMotor.set(0);
    }

    public void stopUpDown () {
        upyDownyMotorRight.set(0);
        upyDownyMotorLeft.set(0);
    }

}
