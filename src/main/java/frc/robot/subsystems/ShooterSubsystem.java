package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Servo;

public class ShooterSubsystem extends SubsystemBase{
    private TalonFX turret = new TalonFX(5);
    private TalonSRX shooter1 = new TalonSRX(6);
    private TalonSRX shooter2 = new TalonSRX(7);
    Servo indexer = new Servo(6);
    private CANSparkMax conveyor1 = new CANSparkMax(14, MotorType.kBrushless);
    private CANSparkMax conveyor2 = new CANSparkMax(17, MotorType.kBrushless);
    private final Encoder shooterEncoder = new Encoder(4, 5);
        
    public ShooterSubsystem(){
    }

    public void conveyor1On(){
        conveyor1.set(-1);
    }
    
    public void conveyor1Off(){
        conveyor1.stopMotor();
        
    }

    public void conveyor2On(){
        conveyor2.set(-1);

    }

    public void conveyor2Off(){
        conveyor2.stopMotor();

    }

    public void conveyor1On(boolean direction){
        if (direction){
            conveyor1.set(-1);
        }
        else {
            conveyor1.set(1);
        }
    }

    public void indexer60(){
       if (indexer.get() == 1.0){
           indexer.set(0);
       }
    }

    public void indexer80(){
       if (indexer.get() == 0){
           indexer.set(1.0);
       }
    }

    public void turretCW(){
        turret.set(ControlMode.PercentOutput, .8);
}

    public void turretCCW(){
        turret.set(ControlMode.PercentOutput, -.8);
    }

    public void turretOff(){
        turret.set(ControlMode.PercentOutput, 0);
    }

    public void shooterOn(double velocity){
        double c = 1;
        double x = (velocity-shooterEncoder.getRate())/velocity;
        shooter1.set(ControlMode.PercentOutput, c);
        shooter2.set(ControlMode.PercentOutput, c);
        if (Math.abs(x) < .06){
            if (shooterEncoder.getRate() > velocity){
                c -= .04;
            }
            else if (shooterEncoder.getRate() < velocity){
                c += .04;
            }
            shooter1.set(ControlMode.PercentOutput, c);
            shooter2.set(ControlMode.PercentOutput, c);
        }
    }

    public void shooterOff(){
        shooter1.set(ControlMode.PercentOutput, 0);
        shooter2.set(ControlMode.PercentOutput, 0);
    }

    public TalonFX speaker1(){
        return turret;
    }

    public void musicMode(boolean music){
        if (music){
            turret.set(ControlMode.MusicTone, 20);
        }
        else{
            turret.set(ControlMode.PercentOutput, 0);
        }
    }

    public void tone(){
        turret.set(ControlMode.MusicTone, 440);
    }
}