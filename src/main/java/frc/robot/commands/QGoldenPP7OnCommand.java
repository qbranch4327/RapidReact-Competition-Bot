package frc.robot.commands;

import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
public class QGoldenPP7OnCommand extends CommandBase {
    private final GoldenPP7Subsystem shooter;
    private MoonRakerSubsystem vision = null;
    private QShakenNotStirredOnCommand intake;

    private final double d1 = 1;
    private final double d2 = 2;
    private final double d3 = 3;
    private final double d4 = 4;
    private final double d5 = 5;
    private final double d6 = 6;
    private final double d7 = 7;

    private final double ips1 = 400;
    private final double ips2 = 700;
    private final double ips3 = 800;

    private Timer timer = new Timer();

    private double velocity = ips2;

    public QGoldenPP7OnCommand(GoldenPP7Subsystem shooter, MoonRakerSubsystem vision, QShakenNotStirredOnCommand intake){
        this.shooter = shooter;
        this.vision = vision;
        this.intake = intake;
        addRequirements(shooter);
        addRequirements(vision);
    }

    public QGoldenPP7OnCommand(GoldenPP7Subsystem shooter, QShakenNotStirredOnCommand intake){
        this.shooter = shooter;
        this.intake = intake;
        addRequirements(shooter);
    }

    @Override
    public void execute(){
        // if (vision.getDistance() < d1){
        //     velocity = ips1;
        //     //add indexer command
        // }
        // else if (vision.getDistance() > d1 && vision.getDistance() < d2){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d2 && vision.getDistance() < d3){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d3 && vision.getDistance() < d4){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d4 && vision.getDistance() < d5){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d5 && vision.getDistance() < d6){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d6 && vision.getDistance() < d7){
        //     velocity = ips2;
        // }
        // else {
        //     velocity = ips3;
        // }

        if (intake.isFinished()){
            timer.reset();
            timer.start();
            shooter.shooterOn(velocity);
            if (timer.get() > 10){
                shooter.shooterOff();
            }
        } 
    }
}
