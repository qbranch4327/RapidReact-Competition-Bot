package frc.robot.subsystems;


//import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private final Spark armMotor = new Spark(0);//tbd
    private final Spark wheelMotor = new Spark(1);//tbd
    private final double armSpeed = 0; //need to update after talking to Mr. Burdette
    private final double wheelSpeed = 0; //need to update after talking to Mr. Burdette
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
