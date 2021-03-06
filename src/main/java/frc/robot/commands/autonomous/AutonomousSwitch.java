package frc.robot.commands.autonomous;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;
import frc.robot.commands.vision.FollowBall;
import frc.robot.commands.vision.RotateToBall;
import frc.robot.subsystems.CellStop;
import frc.robot.subsystems.Subsystems;
public class AutonomousSwitch extends SequentialCommandGroup{
    
    public enum Autopath {
        Top, TopMiddleOurBall, TopMiddleEnemyBall, BottomMiddle, Bottom, TwoBallAuto_Shoot, TwoBallAuto_Intake, FunTest, OneBallAuto_Shoot, SmallerTest, Topshoot2
    }
    public Autopath path;
    public AutonomousSwitch(Autopath path) {
        this.path = path;
        double FILLER_TURNING;
        double FILLER_DRIVING; 
        double FILLER_INTAKE;
        switch(path) {
            case TwoBallAuto_Intake:
                addCommands(
                    // new RotateToBall(),
                    new IntakeDown(),
                    new IntakeIn(),
                    new Wait(2),

                    new DriveStraight(100, 0.3),
                    new IntakeStop()
                    
                );
                break;

            case TwoBallAuto_Shoot:
                addCommands(
                    new IntakeUpDown(),
                    new RunCellStop(0),
                    new RunShooter(0.3, 0.6),

                    new Wait(2),
                    new DriveStraight(-100, 0.5),

                    new Wait(2),
                    new IntakeIn(),
                    new DriveStraight(300, 0.5)
                );
                break;
            case OneBallAuto_Shoot:
            addCommands(
                new IntakeUpDown(),
                new RunShooter(0.3, 0.6),
              
                new IntakeIn(),
                new Wait(4),
                new RunShooter(0, 0),
                new DriveStraight(300, 0.5)
            );
            break;
                
          
            /* case Topshoot2:
                 addCommands(new IntakeUpDown());
                 addCommands(new IntakeIn());
                 addCommands(new DriveStraight(inches, 0.5));
                 addCommands(new IntakeStop());
                 addCommands(new DriveStraight(-inches, 0.5));
                 addCommands(new ShootBall(0.3,0.6));
                 addCommands(new Turn(uTurn, 0.5));
                 addCommands(new IntakeIn());
                 addCommands(new DriveStraight(inches, 0.5));
                 addCommands(new IntakeStop());
                 addCommands(new DriveStraight(-inches, 0.5));
                 addCommands(new Turn(-uTurn, 0.5));
                 addCommands(new ShootBall(0.3,0.6)); */

            case SmallerTest:
                addCommands(new RunShooter(0.3,0.6));

                addCommands(new ShootBall(0.3, 0.6));
                addCommands(new DriveStraight(100, 0.5));
                break;

            case FunTest:
                addCommands(new IntakeUpDown());
                addCommands(new IntakeIn());
                addCommands(new FollowBall());
                addCommands(new DriveStraight(-Subsystems.driveBase.getRightPosition(), 0.5));
                addCommands(new Turn(-Subsystems.driveBase.getGyroAngle(), 0.5));
                break;

            case Top:
                // add it to the priting stuff out
                addCommands(new DriveStraight(80,.5 ));
                addCommands(new IntakeIn());
                addCommands(new Turn(-170,.5 ));
                addCommands(new DriveStraight(110,.5 ));
                addCommands(new DriveStraight(300, .5));
                // Shoot
                break;

            case TopMiddleOurBall:
               // addCommands(new Turn(168,.5 ));  
                addCommands(new DriveStraight(1, .5));
                //Driving to the hub
                // [add shooting comand here]
                addCommands(new Turn(1, .5));
                //Turnes torward our ball
                addCommands(new DriveStraight(1, .5));
                //Drives to our ball
                addCommands(new IntakeIn());
                //Sucks in our ball
                addCommands(new Turn(1, 0.5));
                //Turn twards Enememy ball below (Not nearest one)
                addCommands(new DriveStraight(1, 0.5));
                //Drive twards ball stated above
                addCommands(new Turn(1, 0.5));
                //Turn twards Terminal
                addCommands(new DriveStraight(1, 0.5));
                //Drives twards Terminal
                break;

            case TopMiddleEnemyBall:
                // The first parameter of the commands below are the number of imches to move forwards or degress to turn. THESE ARE ESTIMATES TO BE CHANGED
                // start facing towards ball(blue line)
                addCommands(new DriveStraight(64, .5));
                // move straight (blue line)
                // add shooter commands {
                addCommands(new RunShooter(0.3, 0.6));
                addCommands(new ShootBall(0.3, 0.6));
                //} the above line may be wrong. Please check -Isaiah
                addCommands(new Turn(150, .5));
                // turn right(blue to yellow line)
                addCommands(new DriveStraight(81, .5));
                // move straight (yellow line)
                addCommands(new Turn(-10, .5));
                // turn left(yellow line) - adjusting angle when moving from scoring area to enemy ball
                addCommands(new DriveStraight(81, .5));
                // move straight (yellow line) - getting ball to push
                addCommands(new DriveStraight(81, .5));
                // move straight (yellow line) from ball to human player area
                addCommands(new Turn(-30, .5));
                // turn left(yellow line) - adjusting angle when moving enemy ball to human player area
                addCommands(new DriveStraight(81, .5));
                // move straight (yellow line)
                break;

            case BottomMiddle:
                addCommands(new DriveStraight(1, 0.5));
                // move straight (yellow line) out to get the ball
                addCommands(new DriveStraight(1, 0.5));
                // move backwards (yellow line) to get near the terminal and then shoot
                addCommands(new Turn(1, 0.5));
                // move right (yellow line) to be in right direction to get to human player area
                addCommands(new DriveStraight(1, 0.5));
                // move straight (yellow line) to get to human player area
                break;
            
            case Bottom:
                addCommands(new DriveStraight(80, 0.5));
                // move straight (green line) outwards to intake ball
                addCommands(new Turn(170, 0.5));
                // move right (green line) to be in right direction to move to terminal
                addCommands(new DriveStraight(110, 0.5));
                // move straight (green line) to get to terminal then shoot balls
                addCommands(new Turn(1, 0.5));
                // turn to follow tan line
                addCommands(new DriveStraight(1, 0.5));
                // move straight to follow tan line
                addCommands(new Turn(1, 0.5));
                // turn (tan line) to face human player area
                addCommands(new DriveStraight(1, 0.5));
                // move straight (tan line) to move to human player area
                addCommands(new DriveStraight(1, 0.5));
                // move straight (tan line) back the way we came
                addCommands(new Turn(1, 0.5));
                //turn (tan line) so that shooter is facing terminal
                addCommands(new DriveStraight(1, 0.5));
                // move straight (tan line) to be in postion to shoot and then shoot
                break;


        }

}
}
//Hi. You have reached the end of this file. Have a nice day.