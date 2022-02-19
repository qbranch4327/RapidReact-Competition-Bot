package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import edu.wpi.first.wpilibj.Timer;

public class QYoyoSawOnCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;
    private QShakenNotStirredOnCommand intake;
    private Timer timer = new Timer();
    private final double duration;
    private final double midtime;

    public QYoyoSawOnCommand(GoldenPP7Subsystem shooter, QShakenNotStirredOnCommand intake, double duration, double midtime){
        this.shooter = shooter;
        this.intake = intake;
        this.duration = duration;
        this.midtime = midtime;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){
        shooter.shooterOn(400);
        shooter.conveyor1On();
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
