package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShakenNotStirredSubsystem extends SubsystemBase{
    private final CANSparkMax   armMotor = new CANSparkMax(16, MotorType.kBrushless);
    private final CANSparkMax wheelMotor = new CANSparkMax(15, MotorType.kBrushless);
    private final double armSpeed = 1; 
    private final double wheelSpeed = 1; 
    private Timer timer = new Timer();

    public void intakeOn(boolean direction){
        timer.start();
        if (direction){
            wheelMotor.set(wheelSpeed);
            armMotor.set(.1);
        }
        else{
            wheelMotor.set(-wheelSpeed);
            armMotor.set(.1);
        }
    }

    public void intakeOn(){
        timer.start();
        wheelMotor.set(wheelSpeed);
        armMotor.set(.1);
        if (timer.get() > 1){
            armMotor.stopMotor();
        }
    }

    public void intakeUp(){
        timer.reset();
        wheelMotor.stopMotor();
        armMotor.set(-armSpeed);
    }
    public void intakeOff(){
        timer.reset();
        wheelMotor.stopMotor();
        armMotor.stopMotor();
    }
}