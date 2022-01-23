// //  THINGS TO REMEMBER:
// //  If a function is not labeled to do so it should not be able to do things to the outside world like print stuff, log stuff, and change robot values
// //  Paramaters of each method and function should be labeled in a comment as well as what the function does
// //  Write what the output of a function will be and exactly how it will be

// package frc.robot;
// import java.io.IOException;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import java.util.logging.*;
// import java.time.LocalDateTime;
// // Logs to make
// // Info message - should not happen often but just talks about things like robot is starting to move this amount.
// // Error message - different color and capitalized
// // Warning message - different color and capitalized
// // Status Message - new color and information about speed or some angle. This is will be updated a lot.
// public class RobotLogger {
//     private Logger LOGGER;
//     private FileHandler fileHandler;
//     public RobotLogger(){
//         LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//         this.logInfoMessage( "Log has started at: " + LocalDateTime.now());
//         fileHandler = new FileHandler("status.log"); // BASICALLY https://docs.oracle.com/cd/E17802_01/j2se/j2se/1.5.0/jcp/beta1/apidiffs/java/util/logging/FileHandler.html
//         // our error is not having access to IOException - if there are IO problems opening the files.
//         // SecurityException - if a security manager exists and if the caller does not have LoggingPermission("control")) .
//         LOGGER.addHandler(fileHandler);
//     }
//     public void logErrorMessage(String message){
//         LOGGER.log(Level.SEVERE, message);
//     }
//     public void logWarningMessage(String message){
//         LOGGER.log(Level.WARNING, message);
//     }
//     public void logStatusMessage(String message){
//         LOGGER.log(Level.INFO, message);
//     }
//     public void logInfoMessage(String message){
//         LOGGER.log(Level.FINER, message);
//     }

// }