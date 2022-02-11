package frc.robot;

/**
 * Ports for motor controllers, caps for speed and rotation, booleans for toggles, and turn direction.
 */
public class RobotMap {

    // Robot settings & toggles (mutable)

    private static double speedCap = 0.6;
    private static double rotationCap = 0.5;
    public static double slowSpeedCap = 0.4;
    public static double slowRotCap = 0.3;
    public static double fastSpeedCap = 0.6;
    public static double fastRotCap = 0.5;

    public static boolean isSpeedMode = true;

    // Drive base ports

    public static int leftFollower;
    public static int leftLeader;
    public static int rightFollower;
    public static int rightLeader;
 

    public static int wheelDiameter;
    public static int ticksPerRevolution;
    // Subsystem motor ports
    public static int leftFlywheel;
    public static int rightFlywheel;
    public static int transversalMotor;
    public static int feederWheel;
    public static int succMotor;
    public static int topFlyWheel;
    public static int upyDownyMotorRight;
    public static int upyDownyMotorLeft;
    

    public static int leftClimber;
    public static int rightClimber;
    public static int highClimber;

    // Sensor ports 

    public enum BotNames {
        FALCON, UNITTESTS
    }

    public static BotNames botName;

    /**
     * Sets the bot's ports based off of the bot's name. No further robot-specific setting is needed.
     * @param bot The name of the bot.
     */
    public static void setBot(BotNames bot) {
        botName = bot;
    if (bot == BotNames.FALCON) {
        leftFollower = 2;
        leftLeader = 4;
        rightFollower = 1;
        rightLeader = 3;

        wheelDiameter = 4;
        ticksPerRevolution = 2048;

        leftFlywheel = 422;
        rightFlywheel = 422;
        topFlyWheel = 422;
        transversalMotor = 422;
        succMotor = 422;
        upyDownyMotorRight = 422;
        upyDownyMotorLeft = 422;
        feederWheel = 422;

        leftClimber = 422;
        rightClimber = 422;
        highClimber = 422;
    }
}

    /**
     * @return The speed cap for the drive base in teleop.
     */
    public static double getSpeedCap() {
        return speedCap;
    }

    /**
     * @return The rotation speed cap for the drive base in teleop.
     */
    public static double getRotationCap() {
        return rotationCap;
    }

    /**
     * Sets the caps on speed & rotation for the drive base in teleop.
     * @param newSpeedCap The speed cap to set (0 to 1).
     * @param newRotationCap The rotation speed cap to set (0 to 1).
     */
    public static void setSpeedAndRotationCaps(double newSpeedCap, double newRotationCap) {
        speedCap = (newSpeedCap > 1) ? 1 : newSpeedCap;
        rotationCap = (newRotationCap > 1) ? 1 : newRotationCap;
    }

    public static double convertToTicks(double inches) {
        return (TicksPerRevolution / (wheelDiameter * Math.PI) * inches);
    }
}