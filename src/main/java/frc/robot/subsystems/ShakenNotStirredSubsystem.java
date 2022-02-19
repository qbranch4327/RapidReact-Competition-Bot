package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShakenNotStirredSubsystem extends SubsystemBase{
    private final CANSparkMax   armMotor = new CANSparkMax(16, MotorType.kBrushless);//tbd
    private final CANSparkMax wheelMotor = new CANSparkMax(15, MotorType.kBrushless);//tbd
    private final double armSpeed = .10; 
    private final double wheelSpeed = .5; 
    private final WaitCommand upTime = new WaitCommand(3);
    private final WaitCommand downTime = new WaitCommand(3);

    public void intakeOn(){
        wheelMotor.set(wheelSpeed);
        armMotor.set(armSpeed);
        downTime.initialize();
        downTime.execute();
        SmartDashboard.putString("intake timer: ", downTime.toString());
        if (downTime.isFinished()){
            armMotor.stopMotor();
        }
    }

    public void intakeUp(){
        wheelMotor.set(wheelSpeed);
        armMotor.set(armSpeed*-1.5);
        upTime.initialize();
        upTime.execute();
        SmartDashboard.putString("intake timer: ", upTime.toString());
        if (upTime.isFinished()){
            armMotor.stopMotor();
        }
    }

    public void intakeOff(){
        wheelMotor.stopMotor();
        armMotor.stopMotor();
    }
}