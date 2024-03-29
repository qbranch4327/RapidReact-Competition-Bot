package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ClimbSubsystem extends SubsystemBase {
    private TalonFX climbmotorL = new TalonFX(30);
    private TalonFX climbmotorR = new TalonFX(40);

    public void setRspeed(double speed) {
        climbmotorR.set(ControlMode.PercentOutput, speed);
    }

    public void setLspeed(double speed){
        climbmotorL.set(ControlMode.PercentOutput, speed);
    }
}