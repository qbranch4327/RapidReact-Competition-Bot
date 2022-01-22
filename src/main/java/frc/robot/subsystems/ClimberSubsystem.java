package frc.robot.subsystems;

import frc.Hardware.QTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Hardware.MotorConfigUtils;

public class ClimberSubsystem extends SubsystemBase{
    private QTalonFX climbmotor = new QTalonFX(7, 0, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);//slot tbd (first parameter)
    private final double deadzone = .2;

    public void setspeed(double climbSpeedUp, double climbSpeedDown){
        if (climbSpeedUp > deadzone){
            climbmotor.setPercent(climbSpeedUp);
        }
        if (Math.abs(climbSpeedDown) > deadzone){
            climbmotor.setPercent(climbSpeedDown);
        }
    }
}
