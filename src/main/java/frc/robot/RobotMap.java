package frc.robot;

/**
 * Ports for motor controllers, caps for speed and rotation, booleans for toggles, and turn direction.
 */
public class RobotMap {

    // Robot settings & toggles (mutable)

    // The speed cap that the robot defaults
    private static double speedCap = 0.5;
    private static double rotationCap = 0.3;

    // The speed cap after slow mode is enabled
    public static double slowSpeedCap = 0.3;
    public static double slowRotCap = 0.3;

    // The speed cap after slow mode is enabled
    public static double fineTuneSpeed = 0.1;
    public static double fineTuneRot = 0.1;

    // The rotation cap after fast mode is enabled
    public static double fastSpeedCap = 0.5;
    public static double fastRotCap = 0.3;
    
    // the speed mode
    public static boolean isSpeedMode = true;

    // Drive base ports
    public static int leftFollower;
    public static int leftLeader;
    public static int rightFollower;
    public static int rightLeader;
 
    // drive speed calculation ports
    public static int wheelDiameter;
    public static int ticksPerRevolution;

    // Flyboi
    public static int leftFlywheel;
    public static int rightFlywheel;
    public static int topFlyWheel;

    // Transversal - 1 neo
    public static final int lefttransversalPort = 20;
    public static final int righttransversalPort = 1;

    // Cell Stop - 1 neo
    public static final int cellStopPort = 11;

    // Intake stuff
    // public static int lift = 11;
    public static final int leftextensionInPort = 15;
    public static final int leftextensionOutPort = 0;
    public static final int climberPistonInPort = 14;
    public static final int climberPistonOutPort = 1;
    public static final int intakeMotorPort = 59;
    // public static final int beamBreakPort = 429;
    
    // Shooter
    // public static final int rightFlyPort = 6;
    // public static final int leftFlyPort = 3;
    // public static final int flyRolliRoll = 0;

    // Dimensions for Vision Calculations
    public static final double ballCameraHeightMeters = 0.75;
    public static final double ballHeightMeters = 0.1;
    public static final double ballCameraDegreesHoriz = -25;
    
    public static final double targetCameraHeightMeters = 0.533;
    public static final double targetHeightMeters = 2.642;
    public static final double targetCameraDegreesHoriz = 48;

    public static final int maxNoTargetCounter = 9;
    
    public static final int blueBallPipelineIndex = 0;
    public static final int redBallPipelineIndex = 1;
    
    //PIDFollowBall params for PIDController
    public static double flykP = 1.956521739130435E-4;
    public static double flykI = 0.007739130434782609;
    public static double fkykD = 0.0076521739130434785;
    
    //PIDFlyboi params for PIDController
    public static double HoodFlykP = 0.008782608695652174;
    public static double HoodFlykI = 0.0011739130434782609;
    public static double HoodFlykD = 0.0025652173913043477;

    // Shooter feedforward
    public static double FlykS = 0.89402;
    public static double FlykV = 0.34633;
    public static double FlykA = 0.058598;
    public static double HoodkS = 0.63145;
    public static double HoodkV = 0.90343;
    public static double HoodkA = 0.025781;
    
    // Shooter Expected Velocities in ticks
    // public static double leftVelocity = 2048;
    // public static double rightVelocity = 2048;
    // public static double topVelocity = 2048;
    // public static double leftVelocity = 0.2;
    // public static double topVelocity = 1;
    public static double leftVelocity = 0.3;
    public static double topVelocity = 0.6;

    //Transversal and CellStop speeds during shooter sequence
    public static final double transversalSpeed = 0.3;
    public static final double cellStopSpeed = 0.3;

    //Ball Counter
    public static int ballCounter = 1;

    //Shooter Speed and offsets, as used in ShootBall.java
    public static final double speedCheckOffset = -0.5;
    public static final double speedCheckRange = 5;
    public static boolean driveBaseBreakMode;
        
    
    public enum TeamColor{
        RED,BLUE;
    }

    public static final TeamColor teamColor = TeamColor.RED;

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
        leftFollower = 6;
        leftLeader = 7;
        rightFollower = 5;
        rightLeader = 11;

        wheelDiameter = 4;
        ticksPerRevolution = 2048;

        leftFlywheel = 8;
        rightFlywheel = 9;
        topFlyWheel = 10;

        // Ports probably unused

        leftClimber = 15;
        rightClimber = 16;
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
        return (ticksPerRevolution / (wheelDiameter * Math.PI) * inches);
    }

    public static double cap(double value, double min, double max){
        if(value < min){
            return min;
        } else if (value > max){
            return max;
        }
        return value;
    }
}
