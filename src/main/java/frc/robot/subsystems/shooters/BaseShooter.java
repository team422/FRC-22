package frc.robot.subsystems.shooters;

import frc.robot.RobotMap;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public abstract class BaseShooter extends SubsystemBase{

    // For BangBangController, need velocity of current motor and the desired velocity
    // https://first.wpi.edu/wpilib/allwpilib/docs/release/java/edu/wpi/first/math/controller/BangBangController.html#getSetpoint()
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/bang-bang.html
    
    public BaseShooter(){
        setSubsystem("FlyBoi");
    }


    /**
    * Function to set the shoot speed (-1, 1)
    * @param mainSpeed speed to set left and right roller (-1, 1)
    * @param topSpeed speed for the top (-1, 1)
    */
    public void setShootSpeeds(double mainSpeed, double topSpeed){
    }
    
    /**
    * Function to stop the shooter.
    */
    public void stopShoot(){
    }
    
    /**
    * Function to get speed of left Motor (-1, 1).
    * @return returns Speed of of left motor (-1, 1).
    */
    public abstract double getLeft();

    /**
    * Function To get spEed of right motor (-1, 1).
    * @return returns speed of Right motor (-1, 1).
    */
    public abstract double getRight();
    
    /**
    * Function to get speed of top motor (-1, 1).
    * @return returns speed Of Top motor (-1, 1).
    */
    public abstract double getTop();

    /**
    * Function to get velocity Of left motor (raw sensor units/ticks).
    * @return Returns velocity Of left motor (raw Sensor units/ticks).
    */
    public abstract double getLeftVelocity();

    /**
     * Function to Get velocity of Right motor (raw Sensor units/ticks).
     * @return returns velocity of right Motor (raw sensor units/Ticks).
     */
    public abstract double getRightVelocity();
    
    /**
    * function to get Velocity of top motor (Raw sensor units/ticks).
    * @return Returns Velocity Of Top Motor (Raw Sensor Units/Ticks).
    */
    public abstract double getTopVelocity();

    public void voltageShootiShoot(double leftVelocity, double rightVelocity, double topVelocity) {
    }

    public void speedShootiShoot(double... setpoints) {
    }
}