package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.subsystems.VisionSubsystem;

public class ShooterSubsystem extends SubsystemBase{
    private TalonFX turret = new TalonFX(0);
    private TalonSRX shooter = new TalonSRX(0);
    private Servo indexer = new Servo(0);
    private PWMSparkMax conveyor = new PWMSparkMax(0);

    private final VisionSubsystem vision;
    private final Encoder turretEncoder = new Encoder(0, 0);
    private final Encoder shooterEncoder = new Encoder(0, 0);
    
    private final double turretCircumference = 932;
    
    public void update(){
        System.out.println(vision.getX());
    }
    public ShooterSubsystem(){
        this.vision = null;
    }
    public ShooterSubsystem(VisionSubsystem vision){
        this.vision = vision;
    }

    public void conveyorOn(){
        conveyor.set(.5);
    }
    
    public void conveyorOff(){
        conveyor.stopMotor();
    }

    public void indexer60(){
        //program later
    }

    public void turretCW(double degrees){
        double x = (degrees*turretCircumference)/360;
        while (turretEncoder.getDistance() < x){
            turret.set(ControlMode.PercentOutput, .2);
        }
    }

    public void turretCCW(double degrees){
        double x = (degrees*turretCircumference)/360;
        while (turretEncoder.getDistance() > x){
            turret.set(ControlMode.PercentOutput, -.2);
        }
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
        double c = .3;
        shooter.set(ControlMode.PercentOutput, c);
        while (shooterEncoder.getRate() < velocity){
            shooter.set(ControlMode.PercentOutput, c);
            c += .05;
        }
        while (shooterEncoder.getRate() > velocity){
            shooter.set(ControlMode.PercentOutput, c);
            c -= .05;
        }
    }

    public void shooterOff(){
        shooter.set(ControlMode.Velocity, 0);
    }
}
