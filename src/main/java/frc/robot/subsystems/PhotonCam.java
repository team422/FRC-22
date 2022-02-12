package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class PhotonCam extends SubsystemBase {
    // Make it so that button press initializes this command, checks left and right given specific camera subsystemm gets yaw from there (build subsystem method)
    PhotonCamera frontCam;
    PhotonTrackedTarget target;
    NetworkTableInstance inst;
    NetworkTable photonData;
    NetworkTableEntry yaw;
    NetworkTableEntry pitch;

    public PhotonCam(String camera){
        setSubsystem("PhotonCam");
        this.frontCam = new PhotonCamera(camera);
    }
    
    /**
     * prints the values of hasTarget, pitch, yaw, area, and skew
     */
    public void getAll(){
        try{
            // PhotonLib Strat
            // this.target = frontCam.getLatestResult().getBestTarget();
            // System.out.println(frontCam.getLatestResult().getBestTarget().getYaw());
            // System.out.println(frontCam.getLatestResult().getBestTarget().getPitch());
            // System.out.println(frontCam.getLatestResult().getBestTarget().getArea());
            // System.out.println(frontCam.getLatestResult().getBestTarget().getSkew());
            
            // Network Tables Strat
            // inst.flush(); // needed?
            // inst = NetworkTableInstance.getDefault(); // needed?
            photonData = inst.getTable("photonvision/Microsoft_LifeCam_HD-3000");
            System.out.println(photonData.getEntry("hasTarget").getDouble(0));
            System.out.println(photonData.getEntry("targetPitch").getDouble(0));
            System.out.println(photonData.getEntry("targetYaw").getDouble(0));
            System.out.println(photonData.getEntry("targetArea").getDouble(0));
            System.out.println(photonData.getEntry("targetSkew").getDouble(0));
        } catch(Exception e){
            System.out.println("Error");
        }
    }
    
    /**
     * gets the yaw data value from the vision target
     * @return yaw as a double
     */
    public double getX(){
        // target = frontCam.getLatestResult().getBestTarget();
        // var target = frontCam.getLatestResult().getBestTarget();
        // return target.getYaw();
        
        try{
            // return photonData.getEntry("targetPitch").getDouble(0);
            return frontCam.getLatestResult().getBestTarget().getYaw();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return 0.0;
        }
        // inst.flush(); // needed?
        // inst = NetworkTableInstance.getDefault(); // needed?
        // photonData = inst.getTable("photonvision/FrontHDCam");

        
        // If the above code doesn't work
        // try{
        //     target = frontCam.getLatestResult().getBestTarget();
        //     // var target = frontCam.getLatestResult().getBestTarget();
        //     // return target.getYaw();
            
        //     // inst.flush(); // needed?
        //     // inst = NetworkTableInstance.getDefault(); // needed?
        //     // photonData = inst.getTable("photonvision/FrontHDCam");
        //     yaw = photonData.getEntry("targetYaw");
        //     System.out.println(photonData);
        //     System.out.println(yaw.getDouble(0));
        //     return yaw.getDouble(0);
        // } catch(Exception e) {
        //     // return 0.0;
        //     return 0.0;
        // }
    }

    /**
     * gets the pitch value of vision processing
     * @return the pitch value as a double
     */
    public double getY(){
        try{
            // return photonData.getEntry("targetPitch").getDouble(0);
            return frontCam.getLatestResult().getBestTarget().getPitch();
        } catch(Exception e){
            return 0.0;
        }
    }

    public void snapshot(boolean processed){
        if(processed){
            frontCam.takeOutputSnapshot();
        } else {
            frontCam.takeInputSnapshot();
        }
    }

}