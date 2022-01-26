package frc.robot.commands.SpeedModes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

public class ReleaseSlow extends CommandBase {

    public ReleaseSlow() {
        setName("ReleaseSlow");
        addRequirements(Subsystems.driveBase);
    }

    public void initialize() {
        RobotMap.setSpeedAndRotationCaps(RobotMap.slowSpeedCap, RobotMap.slowRotCap);
        RobotMap.isSpeedMode = false;
    }

    public void end() {
        RobotMap.setSpeedAndRotationCaps(RobotMap.slowSpeedCap, RobotMap.slowRotCap);
        RobotMap.isSpeedMode = true;
    }

    public boolean isFinished() {
        return true;
    }

}