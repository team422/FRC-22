//  THINGS TO REMEMBER:
//  If a function is not labeled to do so it should not be able to do things to the outside world like print stuff, log stuff, and change robot values
//  Paramaters of each method and function should be labeled in a comment as well as what the function does
//  Write what the output of a function will be and exactly how it will be

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
// import frc.robot.commands.*;
// import frc.robot.userinterface.UserInterface;
// import frc.robot.subsystems.*;
import frc.robot.subsystems.FlyShootiShoot;
import frc.robot.subsystems.Subsystems;

/**
 * The main Robot class whence all things come.
 */
public class Robot extends TimedRobot {
    
    // private boolean oldLeftTriggerOn = false;
    // private boolean oldRightTriggerOn = false;
    // private RobotLogger logger = new RobotLogger();

    private boolean left;
    private boolean right;
    private double flySpeed;
    private double hoodSpeed;

    public Robot() {
        super(0.06);
    }

    public void robotInit() {
        //TODO
		RobotMap.setBot(RobotMap.BotNames.FALCON);

        ShuffleboardControl.layoutShuffleboard();
    }

    public void robotPeriodic() {
        //TODO
    }

    public void disabledInit() {
        //TODO
    }

    public void disabledPeriodic() {}

    public void autonomousInit() {
        System.out.println("Autonomous Initalized");
        CommandScheduler.getInstance().cancelAll();
        // this.logger.logInfoMessage("Autonomous Initalized");
        // Schedule autonomous command to run
    }

    public void autonomousPeriodic() {
        // TODO
    }

    public void teleopInit() { 
        // TODO
    }

    public void teleopPeriodic() {
        // TODO
        left = ShuffleboardControl.getLeft();
        right = ShuffleboardControl.getRight();
        flySpeed = ShuffleboardControl.getFlywheelSpeed();
        hoodSpeed = ShuffleboardControl.getHoodSpeed();
        
        Subsystems.flyShootiShoot.wheelSpin(flySpeed, left, right);
        Subsystems.flyShootiShoot.hoodRollerSpin(hoodSpeed);

        Subsystems.flyShootiShoot.setMainPID(ShuffleboardControl.getP(),ShuffleboardControl.getI(),ShuffleboardControl.getD());
    }
}