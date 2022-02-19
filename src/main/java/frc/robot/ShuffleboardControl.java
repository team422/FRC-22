package frc.robot;

import java.util.AbstractMap;
import java.util.Map;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.FlyShootiShoot;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShuffleboardControl {
    private static NetworkTableEntry leftFlywheel;
    private static NetworkTableEntry rightFlywheel;
    private static NetworkTableEntry flywheelSpeed;
    private static NetworkTableEntry hoodRollerSpeed;

    private static NetworkTableEntry kP;
    private static NetworkTableEntry kI;
    private static NetworkTableEntry kD;
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
            .withProperties(Map.of("min", 0, "max", 1))
            .withPosition(4, 2)
            .withSize(2, 3).getEntry();
        hoodRollerSpeed = speeds.add("Hood Roller Speed", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 1))
            .withPosition(4, 4)
            .withSize(2, 3).getEntry();
        
        kP = PID.add("P Constant", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 0.1))
            .withPosition(8, 2)
            .withSize(2, 3).getEntry();
        kI = PID.add("I Constant", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 0.1))
            .withPosition(8, 4)
            .withSize(2, 3).getEntry();
        kD = PID.add("D Constant", 0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 0.1))
            .withPosition(8, 6)
            .withSize(2, 3).getEntry();
        VeloGraph = shooterTab.add("Velocity Graph", 0)
            .getEntry();
        }
    
    public static void setVelocity(){
        VeloGraph.setDouble(Subsystems.flyShootiShoot.getLeftVelocity());
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

    public static double getP() {
        return kP.getDouble(0.0);
    }

    public static double getI() {
        return kI.getDouble(0.0);
    }

    public static double getD() {
        return kD.getDouble(0.0);
    }
}