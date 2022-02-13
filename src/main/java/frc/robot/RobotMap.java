package frc.robot;

// import javax.crypto.interfaces.PBEKey;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class RobotMap {
    // Robot Map is a centralized location at which all the numbers (ports, set speeds, etc) for the Robot can be placed
    // so that it can be replaced easily later if need be. 
    
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

    
    // Speed controls
    public static double speedCap = 0.7;
    public static double rotationCap = 0.3;
    public static double slowSpeedCap = 0.4;
    public static double slowRotCap = 0.3;
    public static double fastSpeedCap = 0.7;
    public static double fastRotCap = 0.3;

    public static boolean isSpeedMode = true;
    
    // Robot Dimensions
    public static double wheelDiameter = 7;

    // motor port numbers
    public enum RobotType{
        COMP, PBOT, TOASTER 
    }

    public static int FlykS = 0;
    public static int FlykV = 0;
    public static int FlykA = 0;

    
    
    // Left side motor port numbers
    public static int leftMiddleMasterPort = 2;

    public static int leftFrontFollower = 3;
    public static int leftBackFollower = 6;
    
    // Right side motor port numbers
    public static int rightMiddleMasterPort = 14;
    
    public static int rightFrontFollower = 5;
    public static int rightBackFollower = 4;

    // Falcon drive ports
    public static int leftFront = 4;
    public static int rightFront = 3;
    public static int leftBack = 2;
    public static int rightBack = 1;

    
    // Intake stuff
    // public static int intakePivot = 46;
    // public static int intakeLeftArm = 9;
    // public static int intakeRightArm = 10;
    // public static int lift = 11;
    public static int extensionMotorPort = 422;
    public static int intakeMotorPort = 422;

    // Shooter
    public static int rightFlyPort = 422;
    public static int leftFlyPort = 422;

    // Dimensions for Vision Calculations
    public static double cameraHeightMeters = 0.25;
    public static double ballHeightMeters = 0.1;
    public static double cameraDegreesHoriz = -25;

    /**
     * @param inches Inches to convert.
     * @return The equivalent distance in ticks (units for Talon Encoders).
     */
    public static double convertToTicks(double inches) {
        return (4096 / (wheelDiameter * 3.1415926) * inches); // Math.PI
    }

    public static double convertTicksToMeters(double ticks) {
        return ((ticks * (wheelDiameter) * (3.1415926)) / 104.0384 ); // Math.PI
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
     * 
     * @param value the arbitrary amount inputted
     * @param min value can't be smaller than min
     * @param max value can't be larger tahn max
     * @return returns the cap if the value is too large/small, but will default to value if it does not reach the cap
     */
    public static void setSpeedAndRotationCaps(double newSpeedCap, double newRotationCap) {
        speedCap = (newSpeedCap > 1) ? 1 : newSpeedCap;
        rotationCap = (newRotationCap > 1) ? 1 : newRotationCap;
    }
}

