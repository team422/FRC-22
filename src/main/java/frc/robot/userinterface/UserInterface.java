package frc.robot.userinterface;

import java.util.ResourceBundle.Control;

public class UserInterface {

    public static final RumbleXboxController driverController = new RumbleXboxController(ControllerSwitcher.XboxDriverController);
    public static final PlayStationController matthewDriverController = new PlayStationController(ControllerSwitcher.MatthewDriverController);
    public static final RumbleXboxController operatorController = new RumbleXboxController(ControllerSwitcher.XboxOperatorController);
    
   


}

