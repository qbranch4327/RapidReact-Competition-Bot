package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QShakenNotStirredCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;
    private final Timer timer;
    private final double duration;

    public QShakenNotStirredCommand(ShakenNotStirredSubsystem intake, double duration){
        this.intake = intake;
        this.duration = duration;
        this.timer = new Timer();
        addRequirements(intake);
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        intake.intakeOn();
    }
    
    @Override
    public boolean isFinished() {
        if (timer.get() > duration){
            intake.intakeOff();
            return true;
        }
        return false;
    }
}