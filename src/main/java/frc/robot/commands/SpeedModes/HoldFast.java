package frc.robot.commands.SpeedModes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

public class HoldFast extends CommandBase {

    public HoldFast() {
        setName("HoldFast");
        addRequirements(Subsystems.driveBase);
    }

    public void initialize() {
        RobotMap.setSpeedAndRotationCaps(RobotMap.fastSpeedCap, RobotMap.fastRotCap);
        RobotMap.isSpeedMode = true;
    }

    public void end() {
        RobotMap.setSpeedAndRotationCaps(RobotMap.slowSpeedCap, RobotMap.slowRotCap);
        RobotMap.isSpeedMode = false;
    }

    public boolean isFinished() {
        return true;
    }

}