package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import edu.wpi.first.wpilibj.Timer;

public class QPGoldenPP7Command extends CommandBase{
    private final GoldenPP7Subsystem shooter;
    private Timer timer;
    private final double duration;
    private final double midtime;
    private final double startTime;

    public QPGoldenPP7Command(GoldenPP7Subsystem shooter, double duration, double midtime, double startTime){
        this.shooter = shooter;
        this.duration = duration + startTime;
        this.midtime = midtime + startTime;
        this.startTime = startTime;
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
        if (timer.get() > startTime){
            shooter.conveyor1On();
            shooter.shooterOn(800);
            if (timer.get() > midtime){
                shooter.conveyor2On();
            }
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
