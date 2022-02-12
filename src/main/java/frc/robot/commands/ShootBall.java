package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class ShootBall extends CommandBase {

    public double lastShooterSpeed;

    public ShootBall(){
        setName("ShootBall");
        addRequirements(Subsystems.flyBoi, Subsystems.cellStop, Subsystems.transversal);
    }

    public void initialize(){
        lastShooterSpeed = 0;
    }
    
    @Override
    public void execute() {
        Subsystems.flyBoi.voltageShootiShoot(RobotMap.leftVelocity, RobotMap.rightVelocity, RobotMap.topVelocity);

        //Starts Transversal and Cellstop after shooter is up to speed
        if (Subsystems.flyBoi.getLeftVelocity() >= RobotMap.leftVelocity - RobotMap.speedCheckRange && Subsystems.flyBoi.getLeftVelocity() <= RobotMap.leftVelocity + RobotMap.speedCheckRange && Subsystems.flyBoi.getTopVelocity() >= RobotMap.topVelocity - RobotMap.speedCheckRange && Subsystems.flyBoi.getTopVelocity() <= RobotMap.topVelocity + RobotMap.speedCheckRange){
            Subsystems.transversal.setTransversalSpeed(RobotMap.transversalSpeed);
            Subsystems.cellStop.setStop(RobotMap.cellStopSpeed);
        } else {
            Subsystems.transversal.stopTransversal();
            Subsystems.cellStop.stopStoppiStop();
        }

        if (Subsystems.flyBoi.getLeftVelocity() - lastShooterSpeed <= RobotMap.speedCheckOffset){
            RobotMap.ballCounter--;
        }
        lastShooterSpeed = Subsystems.flyBoi.getLeftVelocity();
    }

    @Override
    public boolean isFinished() {
        if (RobotMap.ballCounter == 0){
            return true;
        } else {
            return false;
        }
    }

}
