package frc.robot.commands.vision;

import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;
import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;

public class PIDFollowBall extends CommandBase{
    
    PIDController pid;
    
    public void PIDRotateToBall(){
        setName("PIDRotateToBall");
        this.pid = new PIDController(RobotMap.kP, RobotMap.kI, RobotMap.kD);
    }

    public void initialize(){
        // Subsystems.driveBase.zeroGyroAngle();
    }
    
    public void execute(){        
        // double currentAngle = Subsystems.driveBase.getGyroAngle();
        // double turnSpeed = pid.calculate(currentAngle, 45);
        // Subsystems.driveBase.cheesyDrive.tankDrive(turnSpeed, -turnSpeed);
    }

}
