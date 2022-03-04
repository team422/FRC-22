package frc.robot.commands.vision;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.common.hardware.VisionLEDMode;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Subsystems;
import frc.robot.RobotMap;

public class AlignToHub extends CommandBase{

    public int noTargetCounter;
    public double distance;
    public double xPos;
    public double yPos;
    private PhotonTrackedTarget target;
    public double turnSpeed;
    public double travelSpeed;
    private PhotonCamera targetCam = new PhotonCamera("TargetCamera");
    private int pipelineIndex;

    public AlignToHub(){
        setName("AlignToHub");
        addRequirements(Subsystems.driveBase);
        pipelineIndex = 0;
    }
    
    public void initialize(){
    }
    
    public void execute(){
        targetCam.setPipelineIndex(pipelineIndex);
        targetCam.setLED(VisionLEDMode.kOn);
        target = targetCam.getLatestResult().getBestTarget();
        
        if (target == null){
            noTargetCounter++;
            return;
        }
        noTargetCounter = 0;
        yPos = target.getPitch();
        xPos = target.getYaw();
        distance = PhotonUtils.calculateDistanceToTargetMeters(RobotMap.targetCameraHeightMeters, RobotMap.targetHeightMeters, Units.degreesToRadians(RobotMap.targetCameraDegreesHoriz), Units.degreesToRadians(yPos));
        travelSpeed = Math.log1p(distance*10)*0.5;
        travelSpeed *= 0.6;
        travelSpeed = RobotMap.cap(travelSpeed, 0.3, 0.8);
        
        
        turnSpeed = Math.abs(xPos)*0.02;
        turnSpeed = RobotMap.cap(turnSpeed, 0.2, 0.8);
        turnSpeed *= Math.signum(xPos);
        // System.out.println(travelSpeed + " Travel Speed");
        // System.out.println(turnSpeed + " Turn speed");
        // System.out.println("Camera X: " + xPos);
        // System.out.println("Distance: " + distance);
        if(Math.abs(xPos) < 5){
            turnSpeed = 0;
        }
        Subsystems.driveBase.curvatureDrive(0, -turnSpeed, true);
        
    }
    
    public boolean isFinished(){
        if (noTargetCounter > RobotMap.maxNoTargetCounter){
            return true;
        }
        return distance < 0.1;
    }
    
}
