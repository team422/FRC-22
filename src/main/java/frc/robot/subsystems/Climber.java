// Note: This is an annotatd version of the updated 2021 climber code.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// import frc.robot.Robot;
// import edu.wpi.first.wpilibj.*;
// The above import isn't used yet. Uncomment it if you need it and delete this comment later.
import frc.robot.RobotMap;

/**
 * The robot's climber mechanism. S T O N K
 */

//  THINGS TO REMEMBER:
//  If a function is not labeled to do so it should not be able to do things to the outside world like print stuff, log stuff, and change robot values
//  Paramaters of each method and function should be labeled in a comment as well as what the function does
//  Write what the output of a function will be and exactly how it will be

// Notes: we have 2 climbers. Powered by 2 motors. Need to go up and down simultaneous. Motor controller is probably a victor. Maybe a talon.

// May need ot do something special for first bar bc it rotates

// 3 possible plans - 2 arms in the middle of the robot. 1 arm in the middl. or 1 arm in middle and 1 arm in front.

// Os are arms
/**
 *  ----------
 *  |        |
 *  |O      O|   <---- me at 4:22 am - Jakson D. Also the design that we are coding for right now, but it could change
 *  |        |
 *  ----------
 */ 

 /**
 *  ----------
 *  |        |
 *  |   O    |
 *  |        |
 *  ----------
 */ 

 /**
 *  ----------
 *  |    0   |
 *  |    0   |
 *  |        |
 *  ----------
 */ 

public class Climber extends SubsystemBase {
    public WPI_TalonFX LeftClimber;
    public WPI_TalonFX RightClimber;
    public WPI_TalonFX HighClimb;
    public double speed = 0.8;
    public Climber(){
        setSubsystem("Climber");
        this.LeftClimber = new WPI_TalonFX(RobotMap.leftClimber); // We dont know what this value will be "channel - The value will be set in Robotmap.java"
        this.RightClimber = new WPI_TalonFX(RobotMap.rightClimber); // We dont know what this value will be "channel - The value will be set in Robotmap.java"
        this.HighClimb = new WPI_TalonFX(RobotMap.highClimber);
        // find speed in 2021 code and give it a real value or change it later on in the code
        // @param speed The speed at which to extend (0 to 1).
    }


     /**
     * Extends the climber upwards. This lowers the robot if it is in the air. This is according to 2021 code. The new lifter arms may be different
     * so we may need to make changes to this code in order for it to stay relevant. The comments may not remain accurate if the new lifter arm is diffrent
     * from the 2021 arm
     */
     
    public void climberExtendRight(){
        RightClimber.set(speed);
    }

    public void climberExtendLeft(){
        LeftClimber.set(speed);
    }

    public void climberExtendBoth(){
        RightClimber.set(speed);
        LeftClimber.set(speed);
    }

    public void climberExtendHigh() { //High rung climber hook for 2022 season
        HighClimb.set(speed);
    }
    /**
     * Retracts the climber. This raises the robot if the climber is attached to something. This is according to 2021 code. The new lifter arms may be different
     * so we may need to make changes to this code in order for it to stay relevant. The comments may not remain accurate if the new lifter arm is diffrent
     * from the 2021 arm
     */


 
    public void climberRetractRight(){
        RightClimber.set(-speed);
    }
     
    public void climberRetractLeft(){
        LeftClimber.set(-speed);
    }

    public void climberRetractBoth(){
        RightClimber.set(-speed);
        LeftClimber.set(-speed);
    }

    public void climberRetractHigh(){
        HighClimb.set(-speed);
    }

    /**
     * Stops the climber from moving up or down. This raises the robot if the climber is attached to something. This is according to 2021 code. The new lifter
     * arms may be different so we may need to make changes to this code in order for it to stay relevant. The comments may not remain accurate if the new 
     * lifter arm is diffrent from the 2021 arm. This should probably be the same
     */

    public void stopClimberRight() {
        RightClimber.stopMotor();
        // Stops the climber from moving up or down by stopping the right motor.
    } 
    public void stopClimberLeft() {
        LeftClimber.stopMotor();
        // Stops the climber from moving up or down by stopping the left motor.
    }
    public void stopClimberHigh() {
        HighClimb.stopMotor();
    }
    public void stopClimberBoth(){
        RightClimber.stopMotor();
        LeftClimber.stopMotor();
        // Stops the climber from moving up or down by stopping both motors.
    }


}
