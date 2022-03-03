package frc.robot.commands;

import frc.robot.RobotMap;
// import frc.robot.subsystems.Subsystems;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;



public class Wait extends CommandBase {
    double startTime=0;
    double time;
    public Wait(double time) {
        this.time = time * Math.pow(10, 9);
        startTime = System.nanoTime();
        setName("Wait");
        addRequirements(Subsystems.driveBase);
    }

    @Override
    public boolean isFinished() {
        return (System.nanoTime() > startTime + time);
    }

}
