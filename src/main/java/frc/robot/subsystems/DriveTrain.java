// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.robot.commands.*;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Drivetrain extends SubsystemBase {
    private QTalonFX driveMotorLeftA = new QTalonFX(1, drivetrainTicksPerMeter, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);
    private QTalonFX driveMotorLeftB = new QTalonFX(2, drivetrainTicksPerMeter, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);

    private QTalonFX driveMotorRightA = new QTalonFX(3, drivetrainTicksPerMeter, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);
    private QTalonFX driveMotorRightB = new QTalonFX(4, drivetrainTicksPerMeter, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);

    private QTalconFX[] driveMotorAll = new QTalonFX[]{driveMotorLeftA,driveMotorLeftB,driveMotorRightA,driveMotorRightB};
    private QTalconFX[] driveMotorLefts = new QTalcon[]{driveMotorLeftA,driveMotorLeftB};
    private QTalconFX[] driveMotorRights = new QTalcon[]{driveMotorRightA,driveMotorRightB};
    //for when we create our own falcon class

}