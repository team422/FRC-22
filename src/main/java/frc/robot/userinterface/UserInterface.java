package frc.robot.userinterface;

/**
 * Contains instances of all UI elements.
 */
public class UserInterface {

     /**
     * <p>The driver controller (black).</p>
     * Used to control the drive base alone in teleop in Controller DriveModes.
     */
    public static final PlayStationController driverController = new PlayStationController(0);
    public static final RumbleXboxController operatorController = new RumbleXboxController(1);
}