package frc.robot.subsystems;

import edu.wpi.first.motorcontrol.MotorController;
import edu.wpi.first.SpeedController;
import java.lang.AutoCloseable;

public class IntakeSubsystem {
    private final CANSparkMax armMotor;
    private final CANSparkMax wheelMotor;

    public IntakeSubsystem(CANSparkMax armSpark, CANSparkMax wheelSpark){
        this.armMotor = armSpark;
        this.wheelMotor = wheelSpark;
    }

    public void intakeDown(){ //
        
    }

    public void intakeUp(){

    }

    public void intakeOn(){

    }

    public void intakeOff(){

    }
}
