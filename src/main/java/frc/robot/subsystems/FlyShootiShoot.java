package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class FlyShootiShoot extends SubsystemBase {
    // For BangBangController, need velocity of current motor and the desired velocity
    // https://first.wpi.edu/wpilib/allwpilib/docs/release/java/edu/wpi/first/math/controller/BangBangController.html#getSetpoint()
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/bang-bang.html

    CANSparkMax leftShoot;
    CANSparkMax rightShoot;
    SimpleMotorFeedforward feedForward;

    public FlyShootiShoot(){
        this.leftShoot = new CANSparkMax(RobotMap.leftFlyPort, MotorType.kBrushless);
        this.rightShoot = new CANSparkMax(RobotMap.rightFlyPort, MotorType.kBrushless);
        this.feedForward = new SimpleMotorFeedforward(RobotMap.FlykS, RobotMap.FlykV);
    }

    public void setShootSpeed(double speed){
        leftShoot.set(speed);
        rightShoot.set(-speed);
    }
    
    public void stopShoot(){
        leftShoot.set(0);
        rightShoot.set(0);
    }

    public double getVelocity(){
        return leftShoot.getEncoder().getVelocity()/5600;
    }
}