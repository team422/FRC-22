// Uncomment after ports are added

package frc.robot.subsystems;

// import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalInput;

// import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends SubsystemBase{

    DoubleSolenoid intakeSolenoid;
    WPI_TalonSRX intakeMotor;
    DigitalInput beamBreak;
    public boolean isIntakeDown = true;

    public Intake(){
        setSubsystem("Intake");

        // Creating Motors
        this.intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, RobotMap.leftextensionInPort, RobotMap.leftextensionOutPort);
        this.intakeMotor = new WPI_TalonSRX(RobotMap.intakeMotorPort);
        // this.beamBreak = new DigitalInput(RobotMap.beamBreakPort);

    }

    /**
     * Starts the motor that extends/retracts the intake
     * @param speed The speed of extension/retraction (-1,1)
     */
    public void engageExtend(){
        intakeSolenoid.set(Value.kForward);
        // extensionRight.set(Value.kForward);
        isIntakeDown = false;
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
        intakeSolenoid.set(Value.kOff);
        // extensionRight.set(Value.kOff);
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
        intakeSolenoid.set(Value.kReverse);
        // extensionRight.set(Value.kReverse);
        isIntakeDown = true;
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
        return intakeSolenoid.get();
    }


    //comment this out if there is no beam break on robot. Has potential to break things.
    public boolean cellTriggered(){
        return !beamBreak.get();
    }
}
