package frc.robot.userinterface;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RumbleXboxController extends XboxController{
    
    public Joystick joystick;
    public final JoystickButton A, B, X, Y, LB, RB, LS, RS;
    
    public RumbleXboxController(int port){
        super(port);
        this.joystick = new Joystick(port);
        this.A = new JoystickButton(joystick, 1);
        this.B = new JoystickButton(joystick, 2);
        this.X = new JoystickButton(joystick, 3);
        this.Y = new JoystickButton(joystick, 4);
        this.LB = new JoystickButton(joystick, 5);
        this.RB = new JoystickButton(joystick, 6);
        this.LS = new JoystickButton(joystick, 7);
        this.RS = new JoystickButton(joystick, 8);
    }

    /**
     * @return The X axis of the left joystick (-1 to 1).
     */
    public double getLeftJoystickX() {
        return joystick.getRawAxis(0);
    }

    /**
     * @return The Y axis of the left joystick (-1 to 1).
     */
    public double getLeftJoystickY() {
        return joystick.getRawAxis(1);
    }

    /**
     * @return The X axis of the right joystick (-1 to 1).
     */
    public double getRightJoystickX() {
        return joystick.getRawAxis(4);
    }

    /**
     * @return The Y axis of the right joystick (-1 to 1).
     */
    public double getRightJoystickY() {
        return joystick.getRawAxis(5);
    }

    /**
     * @return The degree to which the left trigger has been pushed (0 to 1).
     */
    public double getLeftTrigger() {
        return joystick.getRawAxis(2);
    }

    /**
     * @return The degree to which the right trigger has been pushed (0 to 1).
     */
    public double getRightTrigger() {
        return joystick.getRawAxis(3);
    }

    public int getPOVAngle() {
        return joystick.getPOV(0);
    }

    /**
     * Sets the degree to which the Xbox controller rumbles.
     * @param intensity The value to set the rumble to (0 to 1).
     */
    public void setRumble(double intensity) {
        this.setRumble(RumbleType.kLeftRumble, intensity);
        this.setRumble(RumbleType.kRightRumble, intensity);
    }
}
