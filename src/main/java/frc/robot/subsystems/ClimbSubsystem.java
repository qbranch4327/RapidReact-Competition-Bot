package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ClimbSubsystem extends SubsystemBase{
    private TalonFX climbmotor = new TalonFX(0);
    private final double deadzone = .2;

    public void setspeed(double climbSpeedUp, double climbSpeedDown){
        if (climbSpeedUp > deadzone){
            climbmotor.set(ControlMode.PercentOutput, climbSpeedUp);
        }
        if (Math.abs(climbSpeedDown) > deadzone){
            climbmotor.set(ControlMode.PercentOutput, climbSpeedDown);
        }
    }
}