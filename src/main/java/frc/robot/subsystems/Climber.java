// Note: This is an annotatd version of the updated 2021 climber code.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

// import frc.robot.Robot;
// import edu.wpi.first.wpilibj.*;
// The above import isn't used yet. Uncomment it if you need it and delete this comment later.
import frc.robot.RobotMap;


public class Climber extends SubsystemBase {
    public DoubleSolenoid ClimberBrake;
    public WPI_TalonFX LeftClimber;
    public WPI_TalonFX RightClimber;
    public WPI_TalonFX HighClimb;
    public double speed = 1;
    public Climber(){
        setSubsystem("Climber");
        this.LeftClimber = new WPI_TalonFX(RobotMap.leftClimber); // We dont know what this value will be "channel - The value will be set in Robotmap.java"
        this.RightClimber = new WPI_TalonFX(RobotMap.rightClimber); // We dont know what this value will be "channel - The value will be set in Robotmap.java"
        LeftClimber.setInverted(true);
        // StatorConfig ( bool - shows if the limit is on, int -- amps for limiter, int -- amps for threshold, double -- time for threshold to take effect)
        RightClimber.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 80, 80, .5));
        LeftClimber.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 80, 80, .5));
        RightClimber.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 80, 80, .5));
        LeftClimber.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 80, 80, .5));
        LeftClimber.setNeutralMode(NeutralMode.Brake);
        RightClimber.setNeutralMode(NeutralMode.Brake);
        // LeftClimber.setInverted(true);
        // find speed in 2021 code and give it a real value or change it later on in the code
        // @param speed The speed at which to extend (0 to 1). 
        this.ClimberBrake = new DoubleSolenoid(PneumaticsModuleType.REVPH, RobotMap.climberPistonInPort, RobotMap.climberPistonOutPort);

    }


     /**
     * Extends the climber upwards. This lowers the robot if it is in the air. This is according to 2021 code. The new lifter arms may be different
     * so we may need to make changes to this code in order for it t stay relevant. The comments may not remain accurate if the new lifter arm is diffrent
     * from the 2021 arm
     */
     
    public void climberExtendRight(){
        RightClimber.set(speed);
        ClimberBrake.set(Value.kReverse);
    }

    public void climberExtendLeft(){
        LeftClimber.set(speed);
        ClimberBrake.set(Value.kReverse);
    }

    public void climberExtendBoth(){
        RightClimber.set(speed);
        LeftClimber.set(speed);
        ClimberBrake.set(Value.kReverse);
    }
    /**
     * Retracts the climber. This raises the robot if the climber is attached to something. This is according to 2021 code. The new lifter arms may be different
     * so we may need to make changes to this code in order for it to stay relevant. The comments may not remain accurate if the new lifter arm is diffrent
     * from the 2021 arm
     */


 
    public void climberRetractRight(){
        RightClimber.set(-speed);
        ClimberBrake.set(Value.kForward);
    }
     
    public void climberRetractLeft(){
        LeftClimber.set(-speed);
        ClimberBrake.set(Value.kForward);
    }

    public void climberRetractBoth(){
        RightClimber.set(-speed);
        LeftClimber.set(-speed);
        ClimberBrake.set(Value.kForward);
    }

    public void climberRetractBothNoBrakes(){
        RightClimber.set(-speed);
        LeftClimber.set(-speed);
        ClimberBrake.set(Value.kReverse);
    }

    /**
     * Stops the climber from moving up or down. This raises the robot if the climber is attached to something. This is according to 2021 code. The new lifter
     * arms may be different so we may need to make changes to this code in order for it to stay relevant. The comments may not remain accurate if the new 
     * lifter arm is diffrent from the 2021 arm. This should probably be the same
     */

    public void stopClimberRight() {
        RightClimber.stopMotor();
        ClimberBrake.set(Value.kForward);
        // Stops the climber from moving up or down by stopping the right motor.
    } 
    public void stopClimberLeft() {
        LeftClimber.stopMotor();
        ClimberBrake.set(Value.kForward);
        // Stops the climber from moving up or down by stopping the left motor.
    }
    public void stopClimberBoth(){
        RightClimber.stopMotor();
        LeftClimber.stopMotor();
        // Stops the climber from moving up or down by stopping both motors.
        ClimberBrake.set(Value.kForward);
    }


}
