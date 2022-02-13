package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.*;

public class Transversal extends SubsystemBase {
    private CANSparkMax leftBelt;
    private CANSparkMax rightBelt;

    public Transversal() {
       setSubsystem("Transversal");
       this.leftBelt = new CANSparkMax(RobotMap.leftBelt, MotorType.kBrushless);
       this.rightBelt = new CANSparkMax(RobotMap.rightBelt, MotorType.kBrushless);
    }

    public void stopTransversal() {
        leftBelt.set(0);
        rightBelt.set(0);

    }

    public void startTransversal(int speed) {
        rightBelt.set(speed);
        leftBelt.set(speed);
    }
    
    
}
