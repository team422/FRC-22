// package frc.robot.commands.vision;

// import edu.wpi.first.wpilibj2.command.CommandBase;

// import frc.robot.subsystems.Subsystems;

// public class RotateToTarget extends CommandBase {
    
//     public double xPos;
//     public double weGo;

//     public RotateToTarget(){
//         setName("RotateToBall");
//         addRequirements(Subsystems.driveBase, Subsystems.frontCam);
//         this.weGo = 0;
//     }
//     public void initialize(){
//         xPos = 0.0;
//     }

//     // In the future, add turn command to make it more efficient,
//     // especially with PID; for now, uses tank drive to turn until the 
//     public void execute(){
//         xPos = Subsystems.frontCam.getX();
//         // if(xPos > 0.1){
//         //     Subsystems.driveBase.tank.tankDrive(0.1, -0.1);
//         // } else if(xPos < 0.1){
//         //     Subsystems.driveBase.tank.tankDrive(-0.1, 0.1);
//         // } else {
//         //     Subsystems.driveBase.stopMotors();
//         // }

//         // Better method, change the cap amounts after we fiddle with it
//         // weGo = RobotMap.speedCap*RobotMap.cap(xPos, -40, 40)/40;
//         if(Math.abs(xPos) > 15){
//             Subsystems.driveBase.tank.tankDrive(0.8*Math.signum(xPos),-0.8*Math.signum(xPos));
//         }else{
//             Subsystems.driveBase.tank.tankDrive(0.5*Math.signum(xPos),-0.5*Math.signum(xPos));
//         }
//         // System.out.println(xPos);
//         // Subsystems.driveBase.tank.tankDrive(0.5, 0.5);
//         // Subsystems.frontCam.getAll();
//         // Subsystems.frontCam.getX();
//     }

//     public boolean isFinished(){
//         System.out.println(xPos);
//         return (Math.abs(xPos)<=5);
//         // return true;
//     }
// }
