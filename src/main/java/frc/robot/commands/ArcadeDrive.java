// package frc.robot.commands;

// // import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.RobotMap;
// import frc.robot.subsystems.Subsystems;
// import frc.robot.userinterface.*;

// /**
//  * Uses joystick values to drive the bot in teleop.
//  */
// public class ArcadeDrive extends CommandBase {
//     private double updatedSpeed = 0;
//     private double updatedRotation = 0;
//     private final double maxChange = 0.5; //maxChange is acceleration

//     public ArcadeDrive() {
//         setName("ArcadeDrive");
//         addRequirements(Subsystems.driveBase);
//     }

//     public void execute() {
//         // updatedSpeed = UserInterface.driverController.getLeftJoystickY();
//         // updatedRotation = UserInterface.driverController.getRightJoystickX();
//         double speed;
//         double rotation;
//             if (UserInterface.driverController.getLeftJoystickY() < -0.05) {
//                 speed = -(Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
//             } else if (UserInterface.driverController.getLeftJoystickY() > 0.05) {
//                 speed = (Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
//             } else {
//                 speed = 0;
//             }
//             if (UserInterface.driverController.getRightJoystickX() < -0.05) {
//                 rotation = (Math.pow(UserInterface.driverController.getRightJoystickX(), 5));
//             } else if (UserInterface.driverController.getRightJoystickX() > 0.05) {
//                 rotation = (Math.pow(UserInterface.driverController.getRightJoystickX(), 5));
//             } else {
//                 rotation = 0;
//             }
//             double speedDifference = speed - updatedSpeed;
//             if (speedDifference > maxChange) {
//                 speed = updatedSpeed + maxChange;
//             } else if (speedDifference < -maxChange) {
//                 speed = updatedSpeed - maxChange;
//             }
//             double rotationDifference = rotation - updatedRotation;
//             if (rotationDifference > maxChange) {
//                 rotation = updatedRotation + maxChange;
//             } else if (rotationDifference < -maxChange) {
//                 rotation = updatedRotation - maxChange;
//             }
    
//             updatedSpeed = speed;
//             updatedRotation = rotation;

//             Subsystems.driveBase.curvatureDrive(-rotation * RobotMap.getRotationCap(), speed * RobotMap.getSpeedCap(), true);
//         }
// }

package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.lang.Math;

public class ArcadeDrive extends CommandBase{

    public double rotation;
    public double lastRot;
    public double rotDiff;
    public double speed;
    public double lastSpeed;
    public double speedDiff;

    // public double accelSens = 5; //sensitivity for acceleration
    // public double minAccel; // smallest amount needed for object to move, not really needed but cool to have 
    public double maxAccel = 0.5; // maximum acceleration before it caps out
    public double maxTurnAccel = 0.5; //maximum acceleratioon before it caps out

    public ArcadeDrive(){
        setName("ArcadeDrive");
        addRequirements(Subsystems.driveBase);

        this.rotation = 0;
        this.lastRot = 0;
        this.rotDiff = 0;
        this.speed = 0;
        this.lastSpeed = 0;
        this.speedDiff = 0;
        // System.out.println("Hi1");
    }

    @Override
    public void execute(){
        // System.out.println("Hi2");
        speed = UserInterface.driverController.getLeftJoystickY();
        rotation = UserInterface.driverController.getRightJoystickX();
        
        // // System.out.println(leftSpeed);
        // // System.out.println(rightSpeed);
        // // System.out.println("break");

        // minimium speed is the same for any speed cap right now, but if placed under conditionals, then different
        speed *= RobotMap.getSpeedCap();
        rotation *= RobotMap.getRotationCap();
        
        if(Math.abs(speed) < 0.1){
            speed = 0;
        }

        if(Math.abs(rotation) < 0.1){
            rotation = 0;
        }

        speedDiff = speed - lastSpeed;
        rotDiff = rotation - lastRot;
        
        // // Old acceleration cap basically checked if the speed was over the max change distance,
        // // but I wanted to make just one equationto do that, hence the following:
        // // Needs more work (doesn't work so don't uncomment without fixing)
        // // leftSpeed = leftLastSpeed + (Math.exp(((-1)*accelSens*leftSpeedDiff)-0.7) + maxAccel);
        // // rightSpeed = rightLastSpeed + (Math.exp(((-1)*accelSens*rightSpeedDiff)-0.7) + maxAccel);

        // // Old acceleration but with a ternary operator to simplify it
        speed = Math.abs(speedDiff) > maxAccel ? lastSpeed + Math.signum(speedDiff)*maxAccel : speed;
        rotation = Math.abs(rotDiff) > maxAccel ? lastRot + Math.signum(rotDiff)*maxAccel : rotation;

        lastSpeed = speed;
        lastRot = rotation;

        // System.out.println("Speed: " + leftSpeed);
        // System.out.println(rightSpeed);

        Subsystems.driveBase.curvatureDrive(speed, rotation, true);
    }

}
