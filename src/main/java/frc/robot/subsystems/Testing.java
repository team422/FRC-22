package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Testing extends SubsystemBase {

    WPI_TalonFX testingMotor;

    public Testing(){
        Subsystems.testing.setDefaultCommand(new ArcadeDrive());
        setSubsystem("Testing");

        // Creating Motors
        this.testingMotor = new WPI_TalonFX(0);
    }

    /**
     * Starts the motor that extends/retracts the intake
     * @param speed The speed of extension/retraction (-1,1)
     */
    public void engageExtend(double speed){
        testingMotor.set(speed);
    }


    /**
     * Stops the extension motor
     */
    public void stopExtend(){
        testingMotor.set(0);
    }

    /**
     * Stops the intake motor
     */
    public void stopIntake(){
        testingMotor.set(0);
    }
    
    /**
     * Gets the current position of the extension motor in raw sensor units (consult documentation for conversions)
     */
    public void getExtensionEncoder(){
        testingMotor.getSelectedSensorPosition(0);
    }
}
