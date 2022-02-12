//  THINGS TO REMEMBER:
//  If a function is not labeled to do so it should not be able to do things to the outside world like print stuff, log stuff, and change robot values
//  Paramaters of each method and function should be labeled in a comment as well as what the function does
//  Write what the output of a function will be and exactly how it will be

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
// import frc.robot.commands.SpeedModes.ChangeSpeed;
// import frc.robot.commands.SpeedModes.HoldFast;
// import frc.robot.commands.SpeedModes.ReleaseSlow;
// import frc.robot.userinterface.UserInterface;
// import frc.robot.RobotMap.BotNames;

/**
 * The main Robot class whence all things come.
 */
public class Robot extends TimedRobot {
    
    // private boolean oldLeftTriggerOn = false;
    // private boolean oldRightTriggerOn = false;
    // private RobotLogger logger = new RobotLogger();

    public Robot() {
        super(0.06);
    }

    @Override
    public void robotInit() {
        //initializing things
        RobotMap.setBot(RobotMap.BotNames.FALCON);
        Subsystems.driveBase.setDefaultCommand(new ArcadeDrive());
        
        // Subsystems.driveBase.cheesyDrive.setSafetyEnabled(false);

        //driver controls (buttons)
        // UserInterface.driverController.RB.whenPressed(new ChangeSpeed());
        // UserInterface.driverController.LB.whenPressed(new HoldFast());
        // UserInterface.driverController.LB.whenReleased(new ReleaseSlow());
    }

    @Override
    public void robotPeriodic() {
        //TODO
    }

    @Override
    public void disabledPeriodic() {}

    @Override
    public void autonomousInit() {
        System.out.println("Autonomous Initalized");
        CommandScheduler.getInstance().cancelAll();
        // this.logger.logInfoMessage("Autonomous Initalized");
        // Schedule autonomous command to run
    }

    @Override
    public void autonomousPeriodic() {
        // TODO
    }

    @Override
    public void teleopInit() { 
        System.out.println("TeleOp Initalized");
		CommandScheduler.getInstance().cancelAll();
        // TODO
        // ShuffleboardControl.layoutShuffleboard();
    }

    @Override
    public void teleopPeriodic() {
        // TODO
        // ShuffleboardControl.updateShuffleboard();
    }

    @Override
	public void disabledInit() {
		System.out.println("Disabled Initialized");
	    CommandScheduler.getInstance().cancelAll();
	}
}
