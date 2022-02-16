package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWM;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Servo;

public class GoldenPP7Subsystem extends SubsystemBase{
    private TalonFX turret = new TalonFX(5);
    private TalonSRX shooter1 = new TalonSRX(6);
    private TalonSRX shooter2 = new TalonSRX(7);
    // Servo indexer = new Servo(0);
    private PWMSparkMax conveyor1 = new PWMSparkMax(14);
    private PWMSparkMax conveyor2 = new PWMSparkMax(17);
    private PWMSparkMax conveyorARM = new PWMSparkMax(16);

    private final MoonRakerSubsystem vision;
    private final Encoder turretEncoder = new Encoder(5, 6);
    private final Encoder shooterEncoder = new Encoder(7, 8);
    
    private final double turretCircumference = 932;
    
    // public void update(){
    //     System.out.println(vision.getX());
    // }
    public GoldenPP7Subsystem(){
        this.vision = null;
    }
    public GoldenPP7Subsystem(MoonRakerSubsystem vision){
        this.vision = vision;
    }

    public void conveyor1On(){
        conveyor1.set(.5);
    }
    
    public void conveyor1Off(){
        conveyor1.stopMotor();
        
    }

    public void conveyor2On(){
        conveyor2.set(.5);

    }

    public void conveyor2Off(){
        conveyor2.stopMotor();

    }

    //public void indexer60(){
    //    if (indexer.get() == 1.0){
    //        indexer.set(0);
    //    }
    //}

    //public void indexer80(){
    //    if (indexer.get() == 0){
    //        indexer.set(1.0);
    //    }
    //}

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
        shooter1.set(ControlMode.PercentOutput, c);
        shooter2.set(ControlMode.PercentOutput, c);
        while (shooterEncoder.getRate() < velocity){
            shooter1.set(ControlMode.PercentOutput, c);
            shooter2.set(ControlMode.PercentOutput, c);
            c += .05;
        }
        while (shooterEncoder.getRate() > velocity){
            shooter1.set(ControlMode.PercentOutput, c);
            shooter2.set(ControlMode.PercentOutput, c);
            c -= .05;
        }
    }

    public void shooterOff(){
        shooter1.set(ControlMode.Velocity, 0);
        shooter2.set(ControlMode.Velocity, 0);
    }
}
