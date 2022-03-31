package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QPShakenNotStirredCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;
    private final Timer timer;
    private final double duration;
    private final double startTime;

    public QPShakenNotStirredCommand(ShakenNotStirredSubsystem intake, double duration, double startTime){
        this.intake = intake;
        this.duration = duration + startTime;
        this.startTime = startTime;
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
        if (timer.get() > startTime){
            intake.intakeOn();
        }
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