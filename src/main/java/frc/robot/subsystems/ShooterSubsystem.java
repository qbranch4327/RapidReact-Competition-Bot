package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ShooterSubsystem extends SubsystemBase{
    private TalonFX turret = new TalonFX(0);
    private TalonSRX shooter = new TalonSRX(0);
    private PWMSparkMax indexer = new PWMSparkMax(0);
    private PWMSparkMax conveyor = new PWMSparkMax(0);

    private final DigitalInput index60 = new DigitalInput(0);
    private final DigitalInput index80 = new DigitalInput(0);

    // private final Encoder turretEncoder = new Encoder(0, 0);
    // private final Encoder shooterEncoder = new Encoder(0, 0);

    public void conveyorOn(){
        conveyor.set(.5);
    }
    
    public void conveyorOff(){
        conveyor.stopMotor();
    }

    public void indexer60(){
        if (index80.get()){
            indexer.set(-.05);
        }
        else if (index60.get()){
            indexer.stopMotor();
        }
    }

    public void indexer80(){
        if (index60.get()){
            indexer.set(.15);
        }
        else if (index80.get()){
            indexer.stopMotor();
        }
    }

    public void turretCW(double degrees){
            turret.set(ControlMode.PercentOutput, .5);
    }

    public void turretCCW(double degrees){
        turret.set(ControlMode.PercentOutput, -.5);
    }

    public void turretCW(){
        turret.set(ControlMode.PercentOutput, .5);
}

    public void turretCCW(){
        turret.set(ControlMode.PercentOutput, -.5);
    }

    public void turretOff(){
        turret.set(ControlMode.PercentOutput, 0);
    }

    public void shooterOn(double velocity){
        shooter.set(ControlMode.Velocity, velocity);
    }

    public void shooterOff(){
        shooter.set(ControlMode.Velocity, 0);
    }
}
