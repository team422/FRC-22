package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;

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
        double speed;
        double rotation;

        if (UserInterface.driverController.getLeftJoystickY() < -0.1) {
            speed = -(Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
        } else if (UserInterface.driverController.getLeftJoystickY() > 0.1) {
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

        Subsystems.driveBase.cheesyDrive.curvatureDrive(RobotMap.getRotationCap() * rotation, RobotMap.getSpeedCap() * speed, true);
    }
}