
package frc.robot.test;
import static org.junit.*;

import java.beans.Transient;

// import static org.junit.Assert.assertEquals; 
// import org.junit.Before;
import org.junit.Test;

import frc.robot.RobotMap;
import frc.robot.commands.Turn;
import frc.robot.subsystems.*;
public class DriveStraightTest {
    public static final double DELTA = 12.0;
    DriveStraight driveStraight; 
    
    // float convertTicksToInches(int ticks) {
    //     //Converts ticks to inches
    //     // First convert ticks to rotations
    //     float rotations = ticks/2048;
    //     float inches = roatations*18.84956;
    //     return inches;
    // }
    float convertTicksToInches(int ticks) {
        //Convert ticks to inches
        float rotations = ticks/RobotMap.ticksPerRevolution;
        float inches = rotations*RobotMap.wheelDiameter*Math.PI;
        return inches;
    }
    
    
    
    @After
    public void tearDown() {
        //Dont need this 
    }
    @Before
    DriveStraitTest() {
        // Not needed everyhting is in DriveStraight initializer
    }
    @Test
    public void driveStraightTest_simple_12(){
        driveStraight = new DriveStraight(12);
        assertEquals(12, convertTicksToInches(Subsystems.driveBase.LeftLeader.getSelectedSensorPosition(0)), DELTA);
        assertEquals(12, convertTicksToInches(Subsystems.driveBase.RightLeader.getSelectedSensorPosition(0)), DELTA);
        assertEquals(convertTicksToInches(Subsystems.driveBase.LeftLeader.getSelectedSensorPosition(0)), convertTicksToInches(Subsystems.driveBase.RightLeader.getSelectedSensorPosition(0)), DELTA);
        // MAKE A ATTEMPT TO GO BACKWORDS TO UNDO THIS.
    }
}
