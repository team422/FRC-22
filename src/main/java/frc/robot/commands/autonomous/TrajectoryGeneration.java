package frc.robot.commands.autonomous;

import frc.robot.subsystems.DriveBase;
// import frc.robot.Robot;
import frc.robot.RobotMap;

// import edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
// import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
// import edu.wpi.first.wpilibj2.command.RunCommand;
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.util.List;


public class TrajectoryGeneration {

    public static Command trajectoryGenerate(DriveBase driveBase) {
        // Create a voltage constraint to ensure we don't accelerate too fast
        DifferentialDriveVoltageConstraint autoVoltageConstraint =
        new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(RobotMap.kS,
                                    RobotMap.kV,
                                    RobotMap.kA),
            RobotMap.kKinematics,
            10
        );

        // Create config for trajectory
        TrajectoryConfig config = new TrajectoryConfig(RobotMap.kMaxSpeed, RobotMap.kMaxAcceleration)
            .setKinematics(RobotMap.kKinematics)
            .addConstraint(autoVoltageConstraint);

        Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
            // Start at the origin facing the +X direction
            new Pose2d(0, 0, new Rotation2d(0)),
            // Pass through these two interior waypoints, making an 's' curve path
            List.of(
                new Translation2d(1, 1),
                new Translation2d(2, -1)
            ),
            // End 3 meters straight ahead of where we started, facing forward
            new Pose2d(3, 0, new Rotation2d(0)),
            // Pass config
            config
        );

        RamseteCommand ramseteCommand =
            new RamseteCommand(
                trajectory,
                driveBase::getPose,
                new RamseteController(RobotMap.kRamseteB, RobotMap.kRamseteZeta),
                new SimpleMotorFeedforward(
                    RobotMap.kS,
                    RobotMap.kV,
                    RobotMap.kA),
                RobotMap.kKinematics,
                driveBase::getWheelSpeeds,
                new PIDController(RobotMap.kPDriveVel, 0, 0),
                new PIDController(RobotMap.kPDriveVel, 0, 0),
                driveBase::tankDriveVoltage,
                driveBase
            );
        
        driveBase.resetOdometry(trajectory.getInitialPose());

        return ramseteCommand.andThen(() -> driveBase.tankDriveVoltage(0, 0));
    }
}
