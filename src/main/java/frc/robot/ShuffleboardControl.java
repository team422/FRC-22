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
    private static ShuffleboardTab firstTab;
    
    private static NetworkTableEntry leftEncoderValue;
    private static NetworkTableEntry rightEncoderValue;

    public static void layoutShuffleboard() {
        firstTab = Shuffleboard.getTab("Testing");

        leftEncoderValue = firstTab.add("Left Encoder Value", Subsystems.driveBase.getLeftPosition()).withSize(2, 1).withPosition(0, 0).getEntry();
        rightEncoderValue = firstTab.add("Right Encoder Value", Subsystems.driveBase.getRightPosition()).withSize(2, 1).withPosition(0, 3).getEntry();
    }

    public static void updateShuffleboard() {
        leftEncoderValue.setDouble(Subsystems.driveBase.getLeftPosition());
        rightEncoderValue.setDouble(Subsystems.driveBase.getRightPosition());
    }
}