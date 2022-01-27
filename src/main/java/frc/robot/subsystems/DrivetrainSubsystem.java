// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.Hardware.QTalonFX;
import frc.Hardware.MotorConfigUtils;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private QTalonFX driveMotorLeftA = new QTalonFX(1, 434.68, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);
    private QTalonFX driveMotorLeftB = new QTalonFX(2, 434.68, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);

    private QTalonFX driveMotorRightA = new QTalonFX(3, 434.68, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);
    private QTalonFX driveMotorRightB = new QTalonFX(4, 434.68, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);
    //slots tbd (first parameter for QTalonFX declarations)
    private QTalonFX[] driveMotorLefts = new QTalonFX[]{driveMotorLeftA,driveMotorLeftB};
    private QTalonFX[] driveMotorRights = new QTalonFX[]{driveMotorRightA,driveMotorRightB};

    private final double deadzone = 0.2;

    public void setSpeed(double rightSpeed, double leftSpeed){
        for (var motor : driveMotorLefts){
            if (Math.abs(leftSpeed) > deadzone){
                motor.setPercent(leftSpeed);
            }            
            else{
                motor.setPercent(0);
            }
        }
        
        for (var motor : driveMotorRights){
            if (Math.abs(rightSpeed) > deadzone){
                motor.setPercent(-rightSpeed);
            }
            else{
                motor.setPercent(0);
            }
        }
    }

}