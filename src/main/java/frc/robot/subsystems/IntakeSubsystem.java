package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private final PWMSparkMax armMotor = new PWMSparkMax(0);//tbd
    private final PWMSparkMax wheelMotor = new PWMSparkMax(1);//tbd
    private final double armSpeed = .1; 
    private final double wheelSpeed = .8; 
    private final DigitalInput uplimit = new DigitalInput(0);//tbd
    private final DigitalInput downlimit = new DigitalInput(1);//tbd

    public void intakeOn(){
        wheelMotor.set(wheelSpeed);
        armMotor.set(armSpeed);
        if (downlimit.get()){
            armMotor.stopMotor();
        }
    }

    public void intakeOff(){
        armMotor.set(-armSpeed);
        if (uplimit.get()){
            armMotor.stopMotor();
        }
    }
}