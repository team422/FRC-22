package frc.robot.userinterface;

import edu.wpi.first.wpilibj.XboxController;

public class ControllerSwitcher {

    public static int MatthewDriverController;
    public static int XboxDriverController;
    public static int XboxOperatorController;
   
    public enum ControllerType {
        twoXboxControllers, onePlaystationController
    }
    
    public static ControllerType controllertype; 


    public static void setControllerType (ControllerType controller) {
        controller = controllertype;

        if (controller == ControllerType.twoXboxControllers) {

            MatthewDriverController = 422;
            XboxDriverController = 0;
            XboxOperatorController = 1;
        
        } else if (controller == ControllerType.onePlaystationController){

            MatthewDriverController = 0;
            XboxDriverController = 422;
            XboxOperatorController = 1;

        }
    }
}
