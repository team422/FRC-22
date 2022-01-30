// package frc.robot.commands.vision;

// import java.util.concurrent.SubmissionPublisher;
// // never used

// import edu.wpi.first.wpilibj2.command.CommandBase;

// import frc.robot.subsystems.Subsystems;
// import frc.robot.RobotMap;
// // never used

// public class GetBallDistance extends CommandBase{
//     public double getBallDistance(){
//         // changed name from GetBallDistance() to getBallDistance so naming convention error would go away
//         double pitch = Subsystems.frontCam.getX();
//         double yaw = Subsystems.frontCam.getY();

//         double pitchScalar = 0.764697;
//         double yawScalar = 0.0938183;
//         double pitchPlus = 22.3023;
//         double yawPlus = 4.21832;
//         double sqrtPlus = 173.855;
//         double distance = Math.sqrt(pitchScalar * Math.pow(pitch+pitchPlus,2) + yawScalar * Math.pow(yaw+yawPlus, 2)+sqrtPlus);
//         return distance;
//     }
// }