package frc.robot;

import java.util.AbstractMap;
import java.util.Map;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShuffleboardControl {
    private static NetworkTableEntry leftFlywheel;
    private static NetworkTableEntry rightFlywheel;
    private static NetworkTableEntry flywheelSpeed;
    private static NetworkTableEntry hoodRollerSpeed;

    public static void layoutShuffleboard() {
        ShuffleboardTab shooterTab = Shuffleboard.getTab("Scintillating Shooting Stuff");

        ShuffleboardLayout flywheelMotors =  shooterTab.getLayout("Which flywheel motors are on?", BuiltInLayouts.kList)
            .withPosition(0, 0)
            .withSize(1, 3);
        ShuffleboardLayout speeds = shooterTab.getLayout("Motor speeds", BuiltInLayouts.kList)
            .withPosition(0, 5)
            .withSize(1, 3);

        leftFlywheel = flywheelMotors.add("Left Flywheel", false)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .withPosition(2, 0)
            .withSize(1, 3).getEntry();
        rightFlywheel = flywheelMotors.add("Right Flywheel", false)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .withPosition(4, 0)
            .withSize(1, 3).getEntry();

        flywheelSpeed = speeds.add("Flywheel(s) Speed", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 1))
            .withPosition(2, 5)
            .withSize(1, 3).getEntry();
        hoodRollerSpeed = speeds.add("Hood Roller Speed", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 1))
            .withPosition(4, 5)
            .withSize(1, 3).getEntry();
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
}