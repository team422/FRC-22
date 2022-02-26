package frc.robot.commands;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;

/**
 * Uses joystick values to drive the bot in teleop.
 */
public class ArcadeDrive extends CommandBase {

    public ArcadeDrive() {
        setName("ArcadeDrive");
        addRequirements(Subsystems.testing);
    }

    public void execute() {
        // updatedSpeed = UserInterface.driverController.getLeftJoystickY();
        // updatedRotation = UserInterface.driverController.getRightJoystickX();
        double speed;

        if (UserInterface.driverController.getLeftJoystickY() < -0.05) {
            speed = -(Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
        } else if (UserInterface.driverController.getLeftJoystickY() > 0.05) {
            speed = (Math.pow(UserInterface.driverController.getLeftJoystickY(), 2));
        } else {
            speed = 0;
        }

        Subsystems.testing.engageExtend(speed);

    }
}