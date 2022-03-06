package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class SkyHookSubsystem extends SubsystemBase{
    private TalonFX climbmotorL = new TalonFX(30);
    private TalonFX climbmotorR = new TalonFX(40);

    public void setspeed(boolean climbSpeedUp, boolean climbSpeedDown){
        if (climbSpeedUp){
            climbmotorR.set(ControlMode.PercentOutput, 1);
            climbmotorL.set(ControlMode.PercentOutput, 1);
        }
        else if (climbSpeedDown){
            climbmotorR.set(ControlMode.PercentOutput, -1);
            climbmotorL.set(ControlMode.PercentOutput, -1);

        }
        else {
           climbmotorR.set(ControlMode.PercentOutput, 0);
           climbmotorL.set(ControlMode.PercentOutput, 0);
        }
    }
}