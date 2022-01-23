package frc.robot.userinterface;

/**
 * Contains instances of all UI elements.
 */
public class UserInterface {

     /**
     * <p>The driver controller (black).</p>
     * Used to control the drive base alone in teleop in Controller DriveModes.
     */
    public static final RumbleXboxController driverController = new RumbleXboxController(0);
    public static final RumbleXboxController operatorController = new RumbleXboxController(1);
}