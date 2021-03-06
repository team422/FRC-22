//  THINGS TO REMEMBER:
//  If a function is not labeled to do so it should not be able to do things to the outside world like print stuff, log stuff, and change robot values
//  Paramaters of each method and function should be labeled in a comment as well as what the function does
//  Write what the output of a function will be and exactly how it will be



package frc.robot.subsystems;

import frc.robot.subsystems.drivebases.*;
import frc.robot.subsystems.shooters.*;
import frc.robot.subsystems.*;
/**
 * Contains instances of all subsystems on the robot.
 */
public class Subsystems {
    public static final PhotonCam frontCam = new PhotonCam("Microsoft_LifeCam_HD-3000");
    public static final Intake intake = new Intake();
    public static final Climber climber = new Climber();
    public static final DriveBase driveBase = new FalconDrive();
    public static final FlyBoi flyBoi = new FlyBoi();
    public static final CellStop cellStop = new CellStop();
    
    public static final Transversal transversal = new Transversal();
    public static final ColourSensor colourSensor = new ColourSensor();
} 
