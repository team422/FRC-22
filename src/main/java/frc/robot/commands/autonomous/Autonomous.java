package frc.robot.commands.autonomous;
 
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import java.util.ArrayList;

public class Autonomous {
    
    public void generateTrajectory() {
  
      var sideStart = new Pose2d(Units.feetToMeters(0), Units.feetToMeters(0),
          Rotation2d.fromDegrees(0));
      var crossScale = new Pose2d(Units.feetToMeters(5), Units.feetToMeters(5),
          Rotation2d.fromDegrees(0));
  //these are the initial and final locations in (x,y) format as well as the initial and final headings in degrees)
     
      ArrayList <Translation2d> interiorWaypoints = new ArrayList <Translation2d>();
      interiorWaypoints.add(new Translation2d(Units.feetToMeters(3), Units.feetToMeters(2)));
      interiorWaypoints.add(new Translation2d(Units.feetToMeters(1), Units.feetToMeters(3)));
  //these are the points that the robot must pass over on its way from the initial point to the end point (arbitrary points are in place for now)
     
      TrajectoryConfig config = new TrajectoryConfig(Units.feetToMeters(12), Units.feetToMeters(12));
      config.setReversed(false);
  
      var trajectory = TrajectoryGenerator.generateTrajectory(
          sideStart,
          interiorWaypoints,
          crossScale,
          config);
    }
    
}
