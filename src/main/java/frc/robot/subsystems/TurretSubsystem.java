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

import frc.Hardware.MotorConfigUtils;
import frc.Hardware.QTalonFX;

public class TurretSubsystem {
    private QTalonFX turretMotor = new QTalonFX(6, 111, MotorConfigUtils.POSITION_SLOT_IDX, MotorConfigUtils.VELOCITY_SLOT_IDX);
    //update ticks per inch to actual number when recieved from Mr. Burdette

    public TurretSubsystem(QTalonFX turret){
        //this.turret = turret;
    }

    public void clockwise(){ //will insert info from vision system to parameters
        //turret.set(speed);
        //speed to be determined
        //when encoder reaches blank from vision system
        //turret.stopMotor();
    }

    public void counterclockwise(){ //will insert info from vision system to parameters
        //turret.set(-speed);//tbd
        //when encoder reaches blank
        //turret.stopMotor();
    }

}
