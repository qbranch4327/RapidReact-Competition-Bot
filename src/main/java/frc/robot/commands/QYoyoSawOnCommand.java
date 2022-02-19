package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import edu.wpi.first.wpilibj.Timer;

public class QYoyoSawOnCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;
    private QShakenNotStirredOnCommand intake;
    private Timer timer = new Timer();
    private final double duration;

    public QYoyoSawOnCommand(GoldenPP7Subsystem shooter, QShakenNotStirredOnCommand intake, double duration){
        this.shooter = shooter;
        this.intake = intake;
        this.duration = duration;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        if (intake.isFinished()){
            timer.reset();
            timer.start();
        }
    }

    @Override
    public void execute(){
        shooter.conveyor1On();
        shooter.conveyor2On();
    }

    @Override
    public boolean isFinished() {
        if (timer.get() > duration) {
            shooter.conveyor1Off();
            shooter.conveyor2Off();
        }
        return true;
    }
}
