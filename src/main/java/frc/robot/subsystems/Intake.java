package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends SubsystemBase{

    WPI_TalonSRX extensionMotor;
    WPI_TalonSRX intakeMotor;

    public Intake(){
        setSubsystem("Intake");

        // Creating Motors
        this.extensionMotor = new WPI_TalonSRX(RobotMap.extensionMotorPort);
        this.intakeMotor = new WPI_TalonSRX(RobotMap.intakeMotorPort);

    }

    /**
     * Starts the motor that extends/retracts the intake
     * @param speed The speed of extension/retraction (-1,1)
     */
    public void engageExtend(double speed){
        extensionMotor.set(speed);
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
        extensionMotor.set(0);
    }

    /**
     * Stops the intake motor
     */
    public void stopIntake(){
        intakeMotor.set(0);
    }
    
    /**
     * Gets the current position of the extension motor in raw sensor units (consult documentation for conversions)
     */
    public void getExtensionEncoder(){
        extensionMotor.getSelectedSensorPosition(0);
    }
}
