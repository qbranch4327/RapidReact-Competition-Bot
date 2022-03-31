package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.math.filter.SlewRateLimiter;

public class QPAMDB5Command extends CommandBase {
    private final AMDB5Subsystem drive;
    private final double distance;
    private final double speed;
    private boolean backward = false;
    private double leftDistance;
    private double rightDistance;
    private final GoldenPP7Subsystem shooter;
    private final MoonRakerSubsystem vision;
    private final double startTime;
    private SlewRateLimiter limiter = new SlewRateLimiter(.4, .2);
    private SlewRateLimiter limiterback = new SlewRateLimiter(-.4, -.2);


    private final Timer timer = new Timer();

    public QPAMDB5Command(AMDB5Subsystem drive, double distance, double speed, GoldenPP7Subsystem shooter, MoonRakerSubsystem vision, double startTime) {
        this.drive = drive;
        this.distance = -distance;
        this.speed = speed;
        this.startTime = startTime;
        if (this.distance < 0){
            this.backward = true;
        }
        this.shooter = shooter;
        this.vision = vision;
        addRequirements(shooter);
        addRequirements(vision);
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.resetEncoders();
        drive.publishToDashboard();
        drive.switchToBrakeMode();

    }

    @Override
    public void execute() {
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
        if (timer.get() > startTime){
            if (!backward){
                drive.setSpeed(limiter.calculate(speed), limiter.calculate(speed+.0075));
            }
            else if (backward){
                drive.setSpeed(limiterback.calculate(-speed), limiterback.calculate(-speed-.0075));
            }
            leftDistance = drive.getLeftEncoderDistanceInches();
            rightDistance = drive.getRightEncoderDistanceInches();
    
            System.out.println("left: " + leftDistance);
            System.out.println("right: " + rightDistance);
        }
        

    }

    @Override
    public boolean isFinished() {
        drive.publishToDashboard();
        if (backward){
            if (leftDistance <= this.distance || rightDistance <= this.distance){
                drive.setSpeed(0, 0);
                drive.switchToCoastMode();
                return leftDistance <= this.distance || rightDistance <= this.distance;
            }
        }
        if (!backward){
            if (leftDistance >= this.distance || rightDistance >= this.distance){
                drive.setSpeed(0, 0);
                drive.switchToCoastMode();
                return leftDistance >= this.distance || rightDistance >= this.distance;
            }
        }
        return false;
    }
}
