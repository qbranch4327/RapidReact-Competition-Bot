package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class Q3Commands extends CommandBase{
    private final AMDB5Subsystem drive;
    private final GoldenPP7Subsystem shooter;
    private final MoonRakerSubsystem vision;
    private final ShakenNotStirredSubsystem intake;

    private final double distance1;
    private final double distance2;
    private final double distance3;
    private final double distance4;

    private final double speed = .35;
    
    private double leftDistance;
    private double rightDistance;
    
    private Timer timer;

    private final double intialstart;
    private final double intakedurationTime;
    private final double intake1startTime;
    private final double conveyor1startTime;
    private final double shooter1endTime;
    private final double drive2startTime;
    private final double intake2startTime;
    private final double shooter2startTime;
    private final double conveyor2startTime;
    private final double shooter2endTime;
    private final double drive3startTime;
    private final double drive4startTime;
    private final double drive4endTime;

    public Q3Commands(AMDB5Subsystem drive, MoonRakerSubsystem vision, GoldenPP7Subsystem shooter, ShakenNotStirredSubsystem intake, 
    double distance1, double distance2, double distance3, double distance4, double intialstart, double intakedurationTime, 
    double intake1startTime, double conveyor1startTime, double shooter1endTime, double drive2startTime, double intake2startTime, 
    double shooter2startTime, double conveyor2startTime, double shooter2endTime, double drive3startTime, double drive4startTime, 
    double drive4endTime){
        this.drive = drive;
        this.intake = intake;
        this.vision = vision;
        this.shooter = shooter;
        this.distance1 = distance1;
        this.distance2 = distance2;
        this.distance3 = distance3;
        this.distance4 = distance4;
        this.intialstart = intialstart;
        this.intakedurationTime = intakedurationTime;
        this.intake1startTime = intake1startTime;
        this.conveyor1startTime = conveyor1startTime;
        this.shooter1endTime = shooter1endTime;
        this.drive2startTime = drive2startTime;
        this.intake2startTime = intake2startTime;
        this.shooter2startTime = shooter2startTime;
        this.conveyor2startTime = conveyor2startTime;
        this.shooter2endTime = shooter2endTime;
        this.drive3startTime = drive3startTime;
        this.drive4startTime = drive4startTime;
        this.drive4endTime = drive4endTime;
        timer = new Timer();
        addRequirements(shooter);
        addRequirements(intake);
        addRequirements(vision);
        addRequirements(drive);
    }

    @Override
    public void initialize(){
        drive.resetEncoders();
        drive.publishToDashboard();
        drive.switchToBrakeMode();
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){
        if (vision.getX() < -5){
            while (vision.getX() < -5){
                shooter.turretCCW();
            }
        }
        else if (vision.getX() > 5){
            while (vision.getX() > 5){
                 shooter.turretCW();
            }
        }
        else {
            shooter.turretOff();;
        }
        
        drive.publishToDashboard();

        if (timer.get() > intialstart){
            drive.setSpeed(-speed-.02, -speed+.04);
            leftDistance = drive.getLeftEncoderDistanceInches();
            rightDistance = drive.getRightEncoderDistanceInches();
        }
        if (leftDistance <= this.distance1 || rightDistance <= this.distance1 && timer.get() < drive2startTime){
            drive.setSpeed(0, 0);
        }

        if ((int) (timer.get()) == drive2startTime){
            drive.resetEncoders();
        }

        if (timer.get() > drive2startTime){
            drive.setSpeed((speed+.02), (speed-.04));
            leftDistance = drive.getLeftEncoderDistanceInches();
            rightDistance = drive.getRightEncoderDistanceInches();
        }
        if (leftDistance >= this.distance2 || rightDistance >= this.distance2 && timer.get() < drive3startTime){
            drive.setSpeed(0, 0);
        }

        if (timer.get() == drive3startTime){
            drive.resetEncoders();
        }

        if (timer.get() > drive3startTime){
            drive.setSpeed(-speed, -speed+.01);
            leftDistance = drive.getLeftEncoderDistanceInches();
            rightDistance = drive.getRightEncoderDistanceInches();
        }
        if ((leftDistance <= this.distance3 || rightDistance <= this.distance3) && timer.get() > drive3startTime + 2.5 && timer.get() < drive4startTime){
            drive.setSpeed(0, 0);
        }

        if (timer.get() == drive4startTime){
            drive.resetEncoders();
        }

        if (timer.get() > drive4startTime){
            drive.setSpeed(speed, speed-.01);
            leftDistance = drive.getLeftEncoderDistanceInches();
            rightDistance = drive.getRightEncoderDistanceInches();
        }
        if ((leftDistance >= this.distance4 || rightDistance >= this.distance4)  || timer.get() > drive4endTime){
            drive.setSpeed(0, 0);
        }

        if (timer.get() > intialstart){
            shooter.shooterOn(800);
            if (timer.get() > conveyor1startTime){
                shooter.conveyor1On();
                shooter.conveyor2On();
            }
        }
        if (timer.get() >= shooter1endTime && timer.get() < shooter2startTime){
            shooter.conveyor1Off();
            shooter.conveyor2Off();
            shooter.shooterOff();
        }

        if (timer.get() > shooter2startTime){
            shooter.conveyor1On();
            shooter.shooterOn(800);
            if (timer.get() > conveyor2startTime){
                shooter.conveyor2On();
            }
        }
        if (timer.get() >= shooter2endTime){
            shooter.conveyor1Off();
            shooter.conveyor2Off();
            shooter.shooterOff();
        }

        if (timer.get() > intake1startTime){
            intake.intakeOn();
        }
        if (timer.get() >= intake1startTime + intakedurationTime && timer.get() < intake2startTime){
            intake.intakeOff();
        }
        if (timer.get() > intake2startTime){
            intake.intakeOn();
        }
        if (timer.get() >= intake2startTime + 8){
            intake.intakeOff();
        }
            

    }

    @Override
    public boolean isFinished(){
        if (timer.get() > 14.9){
            drive.switchToCoastMode();
            return true;
        }
        return false;
    }
}
