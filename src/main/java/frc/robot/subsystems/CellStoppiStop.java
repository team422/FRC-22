package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.RobotMap;

public class CellStoppiStop extends SubsystemBase {
    private CANSparkMax stopBoi;
    public CellStoppiStop() {
        setSubsystem("CellStoppiStop");
        this.stopBoi = new CANSparkMax(RobotMap.feederWheel, CANSparkMaxLowLevel.MotorType.kBrushless);
    }

    public void setStoppiStop(double speed) {
        stopBoi.set(speed);
    }

    public void stopStoppiStop() {
        stopBoi.set(0);
    }

}