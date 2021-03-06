package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import edu.wpi.first.wpilibj.Timer;

public class QGoldenPP7Command extends CommandBase{
    private final GoldenPP7Subsystem shooter;
    private Timer timer;
    private final double duration;
    private final double midtime;

    public QGoldenPP7Command(GoldenPP7Subsystem shooter, double duration, double midtime){
        this.shooter = shooter;
        this.duration = duration;
        this.midtime = midtime;
        this.timer = new Timer();
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){
        shooter.conveyor1On();
        shooter.shooterOn(1600);
        if (timer.get() > midtime){
            shooter.conveyor2On();
        }
    }

    @Override
    public boolean isFinished() {
        if (timer.get() > duration) {
            shooter.conveyor1Off();
            shooter.conveyor2Off();
            shooter.shooterOff();
            return true;
        }
        return false;
    }
}
