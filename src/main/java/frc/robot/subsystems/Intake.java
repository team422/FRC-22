// Uncomment after ports are added

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalInput;

// import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends SubsystemBase{

    DoubleSolenoid extension;
    WPI_TalonSRX intakeMotor;
    DigitalInput beamBreak;

    public Intake(){
        setSubsystem("Intake");

        // Creating Motors
        this.extension = new DoubleSolenoid(PneumaticsModuleType.REVPH, RobotMap.extensionInPort, RobotMap.extensionOutPort);
        this.intakeMotor = new WPI_TalonSRX(RobotMap.intakeMotorPort);
        this.beamBreak = new DigitalInput(RobotMap.beamBreakPort);

    }

    /**
     * Starts the motor that extends/retracts the intake
     * @param speed The speed of extension/retraction (-1,1)
     */
    public void engageExtend(){
        extension.set(Value.kForward);
    }
    
    /**
     * Starts the motor that intakes balls
     * @param speed The speed of intake (-1,1)
     */
    public void engageIntake(double speed){
        intakeMotor.set(speed);
    }
    
    /**
     * Stops the extension motor
     */
    public void stopExtend(){
        extension.set(Value.kOff);
    }
    
    /**
     * Stops the intake motor
     */
    public void stopIntake(){
        intakeMotor.stopMotor();
    }
    
    /**
     * Stops the extension motor
     */
    public void retractExtend(){
        extension.set(Value.kReverse);
    }

    /**
     * Stops the intake motor
     */
    public void reverseIntake(double speed){
        intakeMotor.set(-speed);
    }

    /**
     * Gets the current position of the extension motor in raw sensor units (consult documentation for conversions)
     */
    public Value getExtensionState(){
        return extension.get();
    }

    public boolean cellTriggered(){
        return !beamBreak.get();
    }
}
