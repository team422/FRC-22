package frc.robot.userinterface;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeDown;
import frc.robot.commands.IntakeUp;
import frc.robot.commands.IntakeUpDown;
import frc.robot.commands.ManualBreakToggle;
import frc.robot.commands.ManualShoot;
import frc.robot.commands.ManualStopShoot;
import frc.robot.commands.TeleShoot;
import frc.robot.commands.Wait;
import frc.robot.commands.SpeedModes.ChangeSpeed;
import frc.robot.commands.SpeedModes.FineTuneSpeed;
import frc.robot.commands.SpeedModes.HoldFast;
import frc.robot.commands.vision.AlignToHub;
import frc.robot.subsystems.Subsystems;

public class UserControls {

    public static final JoystickButton alignToHubButton = UserInterface.driverController.RB;
    public static final JoystickButton slowFastButton = UserInterface.driverController.LB;
    public static final JoystickButton alignToHub = UserInterface.driverController.B;

    public static final JoystickButton shootSeqButton = UserInterface.operatorController.RB;
    public static final JoystickButton actuateIntakeButton = UserInterface.operatorController.A;
    public static final JoystickButton intakeUpButton = UserInterface.operatorController.X;
    public static final JoystickButton vomitButton = UserInterface.operatorController.LB;
    public static final JoystickButton shootStopButton = UserInterface.operatorController.B;
    // public static final JoystickButton manualBreakToggle = UserInterface.operatorController.X;

    public static void getUserInput() {
        alignToHubButton.whenPressed(new AlignToHub());
        slowFastButton.whenHeld(new HoldFast());
        slowFastButton.whenReleased(new ChangeSpeed());
        // manualBreakToggle.whenPressed(new ManualBreakToggle());
        alignToHub.whenHeld(new AlignToHub());
        
        shootSeqButton.whenHeld(new TeleShoot());
        shootStopButton.whenHeld(new ManualStopShoot());
        shootSeqButton.whenReleased(new ManualStopShoot());
        actuateIntakeButton.whenPressed(new IntakeDown());
        intakeUpButton.whenPressed(new IntakeUp());
        // vomitButton.whenPressed(new Vomit());

        UserInterface.operatorController.LB.whenPressed(new ManualShoot());

        if (UserInterface.operatorController.getPOV()==0) {
            Subsystems.climber.climberExtendBoth();
        } else if(UserInterface.operatorController.getPOV() ==180) {
            Subsystems.climber.climberRetractBoth();
            // Subsystems.climber.climberRetractBothNoBrakes();
        } else {
            Subsystems.climber.stopClimberBoth();
        }

        if(UserInterface.operatorController.LS.get()) {
            Subsystems.climber.climberExtendLeft();
        } 
        if(UserInterface.operatorController.RS.get()) {
            Subsystems.climber.climberExtendRight();
        }

        if (UserInterface.operatorController.getRightJoystickY() <= -0.4) {
            Subsystems.intake.engageIntake(0.6);
            Subsystems.transversal.setTransversalSpeed(0.7);
            // Subsystems.cellStop.setStop(0.4);
        } else if (UserInterface.operatorController.getRightJoystickY() >= 0.4) {
            Subsystems.intake.engageIntake(-0.8);
            Subsystems.transversal.setTransversalSpeed(-0.8);
            // Subsystems.cellStop.setStop(-0.4);
        } else {
            Subsystems.intake.stopIntake();
            Subsystems.transversal.stopTransversal();
        }

        if (UserInterface.operatorController.getLeftJoystickY() <= -0.4) {
            // Subsystems.intake.engageIntake(0.4);
            // Subsystems.transversal.setTransversalSpeed(0.4);
            Subsystems.cellStop.setStop(0.6);
        } else if (UserInterface.operatorController.getLeftJoystickY() >= 0.4) {
            // Subsystems.intake.engageIntake(-0.4);
            // Subsystems.transversal.setTransversalSpeed(-0.4);
            Subsystems.cellStop.setStop(-0.6);
        } else {
            Subsystems.cellStop.stopStoppiStop();
        }
    }
}
