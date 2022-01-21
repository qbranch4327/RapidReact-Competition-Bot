package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX; 

public class ShooterSubsystem {
    public static final double PlaceDistance = 0.1;
    public static final double BackAwayDistance = 0.6;

    private PWMVictorSPX shooter;
    private MotorControllerGroup shooterMotor;
    private DifferentialDrive drive;
    private Encoder shooterEncoder;
    private AnalogGyro gyro;
    private AnalogInput rangefinder;

    public ShooterSubsystem(){
        
    }
}
