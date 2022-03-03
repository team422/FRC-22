package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.revrobotics.ColorMatch;

import frc.robot.Robot;
import frc.robot.RobotMap;



public class ColourSensor extends SubsystemBase {
    ColorSensorV3 m_colorSensor;
    ColorMatch m_colorMatcher;
    private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
    private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
    public ColourSensor(){
        setSubsystem("ColourSensor");
        this.m_colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
        this.m_colorMatcher = new ColorMatch();
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
    }

    public boolean isBallColourGood() {
        Color detectedColor = m_colorSensor.getColor();
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
        if(match.color == kBlueTarget && RobotMap.teamColor == RobotMap.teamColor.BLUE) {
            return true;
        } else if (match.color == kRedTarget && RobotMap.teamColor == RobotMap.teamColor.RED) {
            return true;
        } else {
            return false;
        }
    }

    public Color getTargetColour() {
        Color detectedColor = m_colorSensor.getColor();
        return m_colorSensor.getColor();
    }

}
