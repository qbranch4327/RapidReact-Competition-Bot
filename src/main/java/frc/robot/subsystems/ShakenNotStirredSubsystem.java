package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShakenNotStirredSubsystem extends SubsystemBase{
    private final CANSparkMax   armMotor = new CANSparkMax(16, MotorType.kBrushless);//tbd
    private final CANSparkMax wheelMotor = new CANSparkMax(15, MotorType.kBrushless);//tbd
    private final double armSpeed = .10; 
    private final double wheelSpeed = .5; 
    private Timer timer = new Timer();

    public void intakeOn(){
        timer.start();
        wheelMotor.set(wheelSpeed);
        armMotor.set(armSpeed);
        if (timer.get() > 1){
            armMotor.stopMotor();
        }
    }

    public void intakeUp(){
        timer.start();
        wheelMotor.set(wheelSpeed);
        armMotor.set(armSpeed*-1.5);
        if (timer.get() > 3){
            armMotor.stopMotor();
        }
    }

    public void intakeOff(){
        wheelMotor.stopMotor();
        armMotor.stopMotor();
    }
}