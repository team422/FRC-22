package frc.robot;

// import java.util.AbstractMap;
import java.util.Map;
import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.*;
// import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// import frc.robot.subsystems.shooters.FlyBoi;
import frc.robot.subsystems.Subsystems;
// import frc.robot.userinterface.UserInterface;
// import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShuffleboardControl {
    private static NetworkTableEntry leftFlywheel;
    private static NetworkTableEntry rightFlywheel;
    private static NetworkTableEntry flywheelSpeed;
    private static NetworkTableEntry hoodRollerSpeed;

    private static NetworkTableEntry kPFly;
    private static NetworkTableEntry kIFly;
    private static NetworkTableEntry kDFly;
    private static NetworkTableEntry kPHood;
    private static NetworkTableEntry kIHood;
    private static NetworkTableEntry kDHood;
    private static NetworkTableEntry VeloGraph;

    public static void layoutShuffleboard() {
        ShuffleboardTab shooterTab = Shuffleboard.getTab("Scintillating Shooting Stuff");

        ShuffleboardLayout flywheelMotors =  shooterTab.getLayout("Which flywheel motors are on?", BuiltInLayouts.kList)
            .withPosition(0, 0)
            .withSize(2, 3);
        ShuffleboardLayout speeds = shooterTab.getLayout("Motor speeds", BuiltInLayouts.kList)
            .withPosition(4, 0)
            .withSize(2, 3);
        
        ShuffleboardLayout PID = shooterTab.getLayout("PID values", BuiltInLayouts.kList)
            .withPosition(8, 0)
            .withSize(2, 3);

        leftFlywheel = flywheelMotors.add("Left Flywheel", false)
            .withWidget(BuiltInWidgets.kToggleButton)
            .withPosition(0, 2)
            .withSize(2, 3).getEntry();
        rightFlywheel = flywheelMotors.add("Right Flywheel", false)
            .withWidget(BuiltInWidgets.kToggleButton)
            .withPosition(0, 4)
            .withSize(2, 3).getEntry();

        flywheelSpeed = speeds.add("Flywheel(s) Speed", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 215040))
            .withPosition(4, 2)
            .withSize(2, 3).getEntry();
        hoodRollerSpeed = speeds.add("Hood Roller Speed", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 215040))
            .withPosition(4, 4)
            .withSize(2, 3).getEntry();
        
        kPFly = PID.add("P Constant for Fly Wheel", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 0.1))
            .withPosition(8, 2)
            .withSize(2, 3).getEntry();
        kIFly = PID.add("I Constant for Fly Wheel", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 0.1))
            .withPosition(8, 4)
            .withSize(2, 3).getEntry();
        kDFly = PID.add("D Constant for Fly Wheel", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 0.1))
            .withPosition(8, 6)
            .withSize(2, 3).getEntry();
        // kPHood = PID.add("P Constant for Hood Wheel", 0)
        //     .withWidget(BuiltInWidgets.kNumberSlider)
        //     .withProperties(Map.of("min", 0, "max", 0.1))
        //     .withPosition(6, 2)
        //     .withSize(2, 3).getEntry();
        // kIHood = PID.add("I Constant for Hood Wheel", 0)
        //     .withWidget(BuiltInWidgets.kNumberSlider)
        //     .withProperties(Map.of("min", 0, "max", 0.1))
        //     .withPosition(6, 4)
        //     .withSize(2, 3).getEntry();
        // kDHood = PID.add("D Constant for Hood Wheel", 0)
        //     .withWidget(BuiltInWidgets.kNumberSlider)
        //     .withProperties(Map.of("min", 0, "max", 0.1))
        //     .withPosition(6, 6)
        //     .withSize(2, 3).getEntry();
        VeloGraph = shooterTab.add("Velocity Graph", 0)
            .getEntry();
        }
    
    public static void setVelocity(){
        VeloGraph.setDouble(Subsystems.flyBoi.getAverageVelocity());
    }

        public static boolean getLeft() {
        return leftFlywheel.getBoolean(false);
    }

    public static boolean getRight() {
        return rightFlywheel.getBoolean(false);
    }

    public static double getFlywheelSpeed() {
        return flywheelSpeed.getDouble(0.0);
    }

    public static double getHoodSpeed() {
        return hoodRollerSpeed.getDouble(0.0);
    }

    public static double getPFly() {
        return kPFly.getDouble(0.0);
    }

    public static double getIFly() {
        return kIFly.getDouble(0.0);
    }

    public static double getDFly() {
        return kDFly.getDouble(0.0);
    }

    public static double getPHood() {
        return kPFly.getDouble(0.0);
    }

    public static double getIHood() {
        return kIFly.getDouble(0.0);
    }

    public static double getDHood() {
        return kDFly.getDouble(0.0);
    }
}