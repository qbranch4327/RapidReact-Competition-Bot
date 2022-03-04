package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class SkyHookSubsystem extends SubsystemBase{
    private TalonFX climbmotorL = new TalonFX(30);
    private TalonFX climbmotorR = new TalonFX(40);
    private final double deadzone = .2;

    public void setspeed(double climbSpeedUp, double climbSpeedDown){
        if (climbSpeedUp > deadzone){
            climbmotorR.set(ControlMode.PercentOutput, .2);
            climbmotorL.set(ControlMode.PercentOutput, .2);
        }
        else if (climbSpeedDown > deadzone){
            climbmotorR.set(ControlMode.PercentOutput, -.2);
            climbmotorL.set(ControlMode.PercentOutput, -0.2);

        }
        else
           climbmotorR.set(ControlMode.PercentOutput, 0);
           climbmotorL.set(ControlMode.PercentOutput, 0);

    }
}