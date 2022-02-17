package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShakenNotStirredSubsystem extends SubsystemBase{
    private final CANSparkMax   armMotor = new CANSparkMax(16, MotorType.kBrushless);//tbd
    private final CANSparkMax wheelMotor = new CANSparkMax(15, MotorType.kBrushless);//tbd
    private final double armSpeed = .10; 
    private final double wheelSpeed = .5; 
    // private final DigitalInput uplimit = new DigitalInput(0);//tbd
    // private final DigitalInput downlimit = new DigitalInput(1);//tbd

    public void intakeOn(){
        wheelMotor.set(wheelSpeed);
        armMotor.set(armSpeed);
        // if (downlimit.get()){
        //     armMotor.stopMotor();
        // }
    }

    public void intakeUp(){
        wheelMotor.set(wheelSpeed);
        armMotor.set(armSpeed*-1.5);

    }


    public void intakeOff(){
        wheelMotor.stopMotor();
        armMotor.stopMotor();
        // if (uplimit.get()){
        //     armMotor.stopMotor();
        // }
    }
}