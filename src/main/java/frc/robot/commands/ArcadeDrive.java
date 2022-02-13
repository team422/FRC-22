package frc.robot.commands;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.*;

/**
 * Uses joystick values to drive the bot in teleop.
 */
public class ArcadeDrive extends CommandBase {
    private double updatedSpeed = 0;
    private double updatedRotation = 0;
    private final double maxChange = 0.5; //maxChange is acceleration

    public ArcadeDrive() {
        setName("ArcadeDrive");
        addRequirements(Subsystems.driveBase);
    }

    public void execute() {
        // updatedSpeed = UserInterface.driverController.getLeftJoystickY();
        // updatedRotation = UserInterface.driverController.getRightJoystickX();
        double speed;
        double rotation;

        if (ControllerSwitcher.controllertype == ControllerSwitcher.ControllerType.twoXboxControllers) {

            if (UserInterface.driverController.getLeftJoystickY() < -0.05) {
                speed = -(Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
            } else if (UserInterface.driverController.getLeftJoystickY() > 0.05) {
                speed = (Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
            } else {
                speed = 0;
            }
            if (UserInterface.driverController.getRightJoystickX() < -0.05) {
                rotation = (Math.pow(UserInterface.driverController.getRightJoystickX(), 5));
            } else if (UserInterface.driverController.getRightJoystickX() > 0.05) {
                rotation = (Math.pow(UserInterface.driverController.getRightJoystickX(), 5));
            } else {
                rotation = 0;
            }
            double speedDifference = speed - updatedSpeed;
            if (speedDifference > maxChange) {
                speed = updatedSpeed + maxChange;
            } else if (speedDifference < -maxChange) {
                speed = updatedSpeed - maxChange;
            }
            double rotationDifference = rotation - updatedRotation;
            if (rotationDifference > maxChange) {
                rotation = updatedRotation + maxChange;
            } else if (rotationDifference < -maxChange) {
                rotation = updatedRotation - maxChange;
            }
    
            updatedSpeed = speed;
            updatedRotation = rotation;
    
            Subsystems.driveBase.tank.curvatureDrive(rotation * RobotMap.rotationCap, speed * RobotMap.speedCap, true);
        } else if (ControllerSwitcher.controllertype == ControllerSwitcher.ControllerType.onePlaystationController) {
            if (UserInterface.driverController.getLeftJoystickY() < -0.05) {
                speed = -(Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
            } else if (UserInterface.driverController.getLeftJoystickY() > 0.05) {
                speed = (Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
            } else {
                speed = 0;
            }
            if (UserInterface.driverController.getRightJoystickX() < -0.05) {
                rotation = (Math.pow(UserInterface.driverController.getRightJoystickX(), 5));
            } else if (UserInterface.driverController.getRightJoystickX() > 0.05) {
                rotation = (Math.pow(UserInterface.driverController.getRightJoystickX(), 5));
            } else {
                rotation = 0;
            }
            double speedDifference = speed - updatedSpeed;
            if (speedDifference > maxChange) {
                speed = updatedSpeed + maxChange;
            } else if (speedDifference < -maxChange) {
                speed = updatedSpeed - maxChange;
            }
            double rotationDifference = rotation - updatedRotation;
            if (rotationDifference > maxChange) {
                rotation = updatedRotation + maxChange;
            } else if (rotationDifference < -maxChange) {
                rotation = updatedRotation - maxChange;
            }
    
            updatedSpeed = speed;
            updatedRotation = rotation;
    
            Subsystems.driveBase.tank.curvatureDrive(rotation * RobotMap.rotationCap, speed * RobotMap.speedCap, true);
        }
        Subsystems.driveBase.tank.curvatureDrive(-updatedRotation * RobotMap.rotationCap, updatedSpeed * RobotMap.speedCap, true);
    }
}