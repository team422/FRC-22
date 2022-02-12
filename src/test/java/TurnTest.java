// package frc.robot.test;
// import static org.junit.*;

// import java.beans.Transient;

// // import static org.junit.Assert.assertEquals; 
// // import org.junit.Before;
// import org.junit.Test;
// import frc.robot.commands.Turn;
// import frc.robot.subsystems.*;

// public class TurnTest {
//     public static final double DELTA = 0.01;
//     public static final double DELTA_DEGREES = 5.0;
//     Turn turn;
//     @After
//     public void tearDown() {
//         turn = null;
//     }   
    
//     @Before
//     TurnTest() {
//         Subsystems.driveBase.zeroGyroAngle();
    
//     }
//     @Test
//     public void TurnTest_simple_90() {
//         turn = new Turn(90);
//         assertEquals(90,  Subsystems.driveBase.getGyroAngle(), DELTA_DEGREES);
//     }
//     @Test
//     public void TurnTest_simple_180() {
//         turn = new Turn(180);
//         assertEquals(180,  Subsystems.driveBase.getGyroAngle(), DELTA_DEGREES);
//     }
//     @Test
//     public void TurnTest_simple_5() {
//         turn = new Turn(5);
//         assertEquals(5, Subsystem.driveBase.getGyroAngle(), 2);
//     }
//     @Test 
//     public void TurnTest_simple_45() {
//         turn = new Turn(45);
//         assertEquals(45, Subsystems.driveBase.getGyroAngle(), DELTA_DEGREES);
//     }
//     @Test
//     public void TurnTest_simple_135() {
//         turn = new Turn(135);
//         assertEquals(135, Subsystem.driveBase.getGyroAngle(), DELTA_DEGREES);
//     }
//  }
