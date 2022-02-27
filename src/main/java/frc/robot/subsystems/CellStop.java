package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.RobotMap;

public class CellStop extends SubsystemBase {
    private CANSparkMax stopBoi;
    public CellStop() {
        setSubsystem("CellStop");
        this.stopBoi = new CANSparkMax(RobotMap.cellStopPort, CANSparkMaxLowLevel.MotorType.kBrushless);
    }

    public void setStop(double speed) {
        stopBoi.set(speed);
        if (stopBoi.get() <= 0.4) {
            System.out.println("Not works");
        }
    }

    public void stopStoppiStop() {
        stopBoi.set(0);
    }

}