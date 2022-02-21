package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * Ports for motor controllers, caps for speed and rotation, booleans for toggles, and turn direction.
 */
public class RobotMap {

    // Robot settings & toggles (mutable)

    // The speed cap that the robot defaults
    private static double speedCap = 0.8;
    private static double rotationCap = 0.3;

    // The speed cap after slow mode is enabled
    public static double slowSpeedCap = 0.4;
    public static double slowRotCap = 0.3;

    // The rotation cap after fast mode is enabled
    public static double fastSpeedCap = 0.6;
    public static double fastRotCap = 0.5;
    
    // the speed mode
    public static boolean isSpeedMode = true;

    // Drive base ports
    public static int leftFollower;
    public static int leftLeader;
    public static int rightFollower;
    public static int rightLeader;
 
    // drive speed calculation ports
    public static int ticksPerRevolution;

    // Flyboi
    public static int leftFlywheel;
    public static int rightFlywheel;
    public static int topFlyWheel;
    
    // THESE ARE ALL TRAJECTORY VALUES
    // Drive Station Constants
    public static final double kS = 0.66569;
    public static final double kV = 0.050387;
    public static final double kA = 0.0051628;
    
    public static final double kPDriveVel = 0.064039;
    public static final double kTrack = 0.61;
    public static final DifferentialDriveKinematics kKinematics = new DifferentialDriveKinematics(kTrack);
    
    public static final double kMaxSpeed = 20;
    public static final double kMaxAcceleration = 3;

    // Ramsete Controller Gains
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    // Transversal - 1 neo
    public static final int transversalPort = 423;

    // Cell Stop - 1 neo
    public static final int cellStopPort = 1086;

    // Intake stuff
    // public static int lift = 11;
    public static final int extensionInPort = 424;
    public static final int extensionOutPort = 427;
    public static final int intakeMotorPort = 420;
    public static final int beamBreakPort = 429;
    
    // Shooter
    public static final int rightFlyPort = 6;
    public static final int leftFlyPort = 3;
    public static final int flyRolliRoll = 0;

    // Dimensions for Vision Calculations
    public static final double ballCameraHeightMeters = 0.75;
    public static final double ballHeightMeters = 0.1;
    public static final double ballCameraDegreesHoriz = -25;
    
    public static final double targetCameraHeightMeters = 0.79;
    public static final double targetHeightMeters = 2.642;
    public static final double hubCameraDegreesHoriz = 15;

    public static final int maxNoTargetCounter = 9;
    
    public static final int blueBallPipelineIndex = 0;
    public static final int redBallPipelineIndex = 1;
    
    //PIDFollowBall params for PIDController
    public static double kP = 1;
    public static double kI = 1;
    public static double kD = 1;
    
    //PIDFlyboi params for PIDController
    public static double FlykP = 1;
    public static double FlykI = 1;
    public static double FlykD = 1;
    public static double HoodFlykD = 1;
    public static double HoodFlykI = 1;
    public static double HoodFlykP = 1;

    // Shooter feedforward
    public static int FlykS = 0;
    public static int FlykV = 0;
    public static int FlykA = 0;

    // Shooter Expected Velocities in ticks
    public static double leftVelocity = 0;
    public static double rightVelocity = 0;
    public static double topVelocity = 0;

    //Transversal and CellStop speeds during shooter sequence
    public static final double transversalSpeed = 0.15;
    public static final double cellStopSpeed = 0.3;

    //Ball Counter
    public static int ballCounter = 1;

    //Shooter Speed and offsets, as used in ShootBall.java
    public static final double speedCheckOffset = -0.5;
    public static final double speedCheckRange = 5;
        
    
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
        leftFollower = 2;
        leftLeader = 4;
        rightFollower = 1;
        rightLeader = 3;

        // wheelDiameter = 4;
        ticksPerRevolution = 2048;

        leftFlywheel = 422;
        rightFlywheel = 422;
        topFlyWheel = 422;

        // Ports probably unused
        // transversalMotor = 422;
        // succMotor = 422;
        // upyDownyMotorRight = 422;
        // upyDownyMotorLeft = 422;
        // feederWheel = 422;

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

    public static double convertToTicks(double inches, int wheelDiameter) {
        return ( ticksPerRevolution / (wheelDiameter * Math.PI) * inches );
    }

    public static double convertTicksToMeters(double ticks, int wheelDiameter) {
        return ( (ticks * (wheelDiameter) * Math.PI) / 104.0384 );
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
