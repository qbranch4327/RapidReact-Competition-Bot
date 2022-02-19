package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import edu.wpi.first.wpilibj.Timer;

public class QYoyoSawOnCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;
    private QShakenNotStirredOnCommand intake;
    private Timer timer = new Timer();

    public QYoyoSawOnCommand(GoldenPP7Subsystem shooter, QShakenNotStirredOnCommand intake){
        this.shooter = shooter;
        this.intake = intake;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        if (intake.isFinished()){
            timer.reset();
            timer.start();
            shooter.conveyor1On();
            if (timer.get() > 2){
                shooter.conveyor2On();
            }
            if (timer.get() > 7){
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
