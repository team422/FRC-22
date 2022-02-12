// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.commands.*;
import frc.robot.commands.SpeedModes.*;
// import frc.robot.commands.vision.*;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
	public Robot(){
    	super(0.08);
	}

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  	@Override
	public void robotInit() {    
		Subsystems.driveBase.setDefaultCommand(new ArcadeDrive());

		UserInterface.driverController.RB.whenPressed(new ChangeSpeed());
        UserInterface.driverController.LB.whenPressed(new HoldFast());
        UserInterface.driverController.LB.whenReleased(new ReleaseSlow());

		// Might need to be moved to teleopPeriodic in order to function, but it might also work here.
		// UserInterface.driverController.A.whenPressed(new RotateToBall());
		// UserInterface.driverController.X.whenPressed(new FollowBall());
  	}

	@Override
  	public void robotPeriodic() {
    	CommandScheduler.getInstance().run();
  	}

	@Override
	public void autonomousInit() {
		System.out.println("Autonomous Initalized");
    	CommandScheduler.getInstance().cancelAll();
	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopInit() {
		System.out.println("TeleOp Initalized");
		CommandScheduler.getInstance().cancelAll();
	}

  @Override
	public void teleopPeriodic() {
	}

  @Override
	public void disabledInit() {
		System.out.println("Disabled Initialized");
	    CommandScheduler.getInstance().cancelAll();
	}

	@Override
	public void disabledPeriodic() {}

	@Override
	public void testInit() {}

	@Override
	public void testPeriodic() {}
}
