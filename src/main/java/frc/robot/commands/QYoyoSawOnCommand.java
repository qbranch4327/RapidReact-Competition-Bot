package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import edu.wpi.first.wpilibj.Timer;

public class QYoyoSawOnCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;
    private QShakenNotStirredOnCommand intake;
    private Timer timer;
    private double x; 

    public QYoyoSawOnCommand(GoldenPP7Subsystem shooter, QShakenNotStirredOnCommand intake, Timer time, double x){
        this.shooter = shooter;
        this.intake = intake;
        this.timer = time;
        this.x = x;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        if (timer.get() - x > 6){
            shooter.conveyor1On();
            if (timer.get() > 7){
                shooter.conveyor2On();
            }
            if (timer.get() > 10){
                shooter.conveyor1Off();
                shooter.conveyor2Off();
            }
        }
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
