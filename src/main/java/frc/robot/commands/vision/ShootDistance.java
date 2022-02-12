package frc.robot.commands.vision;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Subsystems;
import frc.robot.RobotMap;

public class ShootDistance extends CommandBase{
    
    private PhotonCamera targetCamera = new PhotonCamera("TargetCamera");
    private PhotonTrackedTarget target;
    private double xPos;
    private double yPos;
    private double distance;

    public ShootDistance(){
        setName("AlignHub");
        addRequirements(Subsystems.driveBase);
    }

    public void initialize(){

    }

    public void execute(){
        target = targetCamera.getLatestResult().getBestTarget();
        if (target == null){
            return;
        }
        xPos = target.getYaw();
        yPos = target.getPitch();
        distance = PhotonUtils.calculateDistanceToTargetMeters(RobotMap.targetCameraHeightMeters, RobotMap.targetHeightMeters, Units.degreesToRadians(RobotMap.hubCameraDegreesHoriz), Units.degreesToRadians(target.getPitch()));
        System.out.println(distance);

    }

}
