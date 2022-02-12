// package frc.robot.commands;

// import frc.robot.subsystems.*;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.userinterface.UserInterface;



// public class IntakeUpDown extends CommandBase {

//     /*
//     command to control the upDown motor on the intake!
//     */
//     public IntakeUpDown() {
//         setName("IntakeUpDown");
//         addRequirements(Subsystems.intake);
//     }

//     //wpilib looks for initialize, execute, and end!
//     public void initialize() {
//     }

//     public void execute() {
        
//         //sets speed of upDown motor based on xboxcontroller right joystick value
//         if(UserInterface.operatorController.getRightJoystickY() > 0.1){
//             Subsystems.intake.engageExtend();
//         } else if(UserInterface.operatorController.getRightJoystickY() < -0.1){
//             Subsystems.intake.retractExtend();
//         }
        
//     }

//     public void end() {
//         Subsystems.intake.stopExtend();
//     }

//     public boolean isFinished() {
//         return true; 
//     }
    
// }

