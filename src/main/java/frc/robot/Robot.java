//  THINGS TO REMEMBER:
//  If a function is not labeled to do so it should not be able to do things to the outside world like print stuff, log stuff, and change robot values
//  Paramaters of each method and function should be labeled in a comment as well as what the function does
//  Write what the output of a function will be and exactly how it will be

package frc.robot;

import org.photonvision.PhotonCamera;
import org.photonvision.common.hardware.VisionLEDMode;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ContinuouslyRunCellStop;
import frc.robot.commands.autonomous.AutonomousSwitch;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserControls;
/**
 * The main Robot class whence all things come.
 */
public class Robot extends TimedRobot {

	// private boolean oldLeftTriggerOn = false;
	// private boolean oldRightTriggerOn = false;
	// private RobotLogger logger = new RobotLogger();
	// private boolean oldTriggerOn = false;

	private Compressor compressor;

	public Robot() {
		super(0.06);
	}

	@Override
	public void robotInit() {
		// initializing things
		RobotMap.setBot(RobotMap.BotNames.FALCON);
		Subsystems.driveBase.setDefaultCommand(new ArcadeDrive());
		compressor = new Compressor(PneumaticsModuleType.REVPH);
		compressor.enableDigital();
		Subsystems.intake.retractExtend();

		ShuffleboardControl.layoutShuffleboard();



		// Subsystems.driveBase.driveBase.setSafetyEnabled(false);

		// driver controls (buttons)
		// UserInterface.driverController.RB.whenPressed(new ChangeSpeed());
		// UserInterface.driverController.LB.whenPressed(new HoldFast());
		// UserInterface.driverController.LB.whenReleased(new ReleaseSlow());
	}
	
	@Override
	public void robotPeriodic() {
		CommandScheduler.getInstance().run();
		ShuffleboardControl.setVelocity();

		// TODO
	}

	@Override
	public void disabledPeriodic() {
	}

	@Override
	public void autonomousInit() {
		Subsystems.driveBase.toggleBrakeMode(false);
		System.out.println("Autonomous Initalized");
		CommandScheduler.getInstance().cancelAll();
		// this.logger.logInfoMessage("Autonomous Initalized");
		// Schedule autonomous command to run
		Subsystems.cellStop.setDefaultCommand(new ContinuouslyRunCellStop());
        CommandScheduler.getInstance().schedule(
			CommandGroupBase.sequence(
				new AutonomousSwitch(AutonomousSwitch.Autopath.OneBallAuto_Shoot)
			)
		);
        // addCommands(new IntakeUpDown());
        // addCommands(new IntakeIn());
        // addCommands(new DriveStraight(-200, 0.5));
        // addCommands(new IntakeStop());
        // Subsystems.cellStop.setStop(-0.5);
        // addCommands(new IntakeUpDown());
        // addCommands(new DriveStraight(200, 0.5));
        // addCommands(new ShootBall(0.3, 0.6));
	}

	@Override
	public void autonomousPeriodic() {
		// TODo
        

		// PID Stuff uncomment when testing PID
		// Subsystems.flyBoi.setTopPID(
		// 	ShuffleboardControl.getPFly(),
		// 	ShuffleboardControl.getIFly(),
		// 	ShuffleboardControl.getDFly()
		// );

		// System.out.println(ShuffleboardControl.getHoodSpeed());

		// Subsystems.flyBoi.voltageShootiShoot(
		// 	ShuffleboardControl.getFlywheelSpeed(),
		// 	ShuffleboardControl.getFlywheelSpeed(),
		// 	ShuffleboardControl.getHoodSpeed()
		// );

	}

	@Override
	public void teleopInit() {
		new PhotonCamera("TargetCamera").setLED(VisionLEDMode.kOn);
		RobotMap.driveBaseBreakMode = false;
		Subsystems.driveBase.toggleBrakeMode(false);
		System.out.println("TeleOp Initalized");
		CommandScheduler.getInstance().cancelAll();
		Subsystems.cellStop.setDefaultCommand(new ContinuouslyRunCellStop());
		
		// TODO
		// ShuffleboardControl.layoutShuffleboard();
	}

	@Override
	public void teleopPeriodic() {
		// System.out.println(Subsystems.colourSensor.getProximity());
		// TODO
		// Controls
		UserControls.getUserInput();
	}

	@Override
	public void disabledInit() {
		System.out.println("Disabled Initialized");
		CommandScheduler.getInstance().cancelAll();
	}
}
