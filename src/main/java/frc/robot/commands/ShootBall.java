package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.userinterface.*;
import frc.robot.subsystems.Subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class ShootBall extends CommandBase {

    public double lastShooterSpeed;

    public ShootBall(){
        setName("ShootBall");
        addRequirements(Subsystems.flyBoi, Subsystems.cellStop, Subsystems.transversal);
    }

    @Override
    public void initialize(){
        lastShooterSpeed = 0;
    }

    // just checks if any two given values r in a range! :)
    public boolean isInRangeOrEqual(double lower, double upper, double val){
        if(val >= lower && val <= upper){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void execute() {
        
        Subsystems.flyBoi.voltageShootiShoot(RobotMap.leftVelocity, RobotMap.rightVelocity, RobotMap.topVelocity);

        double lowerBound = RobotMap.leftVelocity - RobotMap.speedCheckRange; // lower bound of speed range
        double upperBound = RobotMap.leftVelocity + RobotMap.speedCheckRange; // upper bound of speed range
        boolean leftVelocityInRange = isInRangeOrEqual(lowerBound, upperBound, Subsystems.flyBoi.getLeftVelocity()); // checks if [which motor?] is in correct speed range
        boolean topVelocityInRange = isInRangeOrEqual(lowerBound, upperBound, Subsystems.flyBoi.getTopVelocity()); // checks if [which motor?] is in correct speed range

        // Starts Transversal and Cellstop after shooter is up to velocity listed in robotmap
        if (leftVelocityInRange && topVelocityInRange){
            Subsystems.transversal.setTransversalSpeed(RobotMap.transversalSpeed);
            Subsystems.cellStop.setStop(RobotMap.cellStopSpeed);
        } else {
            Subsystems.transversal.stopTransversal();
            Subsystems.cellStop.stopStoppiStop();
        }
    //     if (Subsystems.flyBoi.getLeftVelocity() >= RobotMap.leftVelocity - RobotMap.speedCheckRange && Subsystems.flyBoi.getLeftVelocity() <= RobotMap.leftVelocity + RobotMap.speedCheckRange && Subsystems.flyBoi.getTopVelocity() >= RobotMap.topVelocity - RobotMap.speedCheckRange && Subsystems.flyBoi.getTopVelocity() <= RobotMap.topVelocity + RobotMap.speedCheckRange){
    //        Subsystems.transversal.setTransversalSpeed(RobotMap.transversalSpeed);
    //        Subsystems.cellStop.setStop(RobotMap.cellStopSpeed);
    //    } else {
    //        Subsystems.transversal.stopTransversal();
    //        Subsystems.cellStop.stopStoppiStop();
    //    }

        if (Subsystems.flyBoi.getLeftVelocity() - lastShooterSpeed <= RobotMap.speedCheckOffset){
            //checks if the velocity dips below a certain threshold. If that happens then it will count down one ball.
            RobotMap.ballCounter--;
        }
        lastShooterSpeed = Subsystems.flyBoi.getLeftVelocity();
    }

    @Override
    public boolean isFinished() {
        //if there are no balls then don't shoot.
        if (RobotMap.ballCounter == 0 || UserInterface.operatorController.getRightBumper()){
            return true;
        } else {
            return false;
        }
    }

}
