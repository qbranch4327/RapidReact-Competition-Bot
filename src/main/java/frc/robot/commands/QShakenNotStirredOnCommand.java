package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QShakenNotStirredOnCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;
    private final Timer timer = new Timer();
    private QAMDB5Command drivetrain;
    private final double duration;

    public QShakenNotStirredOnCommand(ShakenNotStirredSubsystem intake, QAMDB5Command drivetrain, double duration){
        this.intake = intake;
        this.drivetrain = drivetrain;
        this.duration = duration;
        addRequirements(intake);
    }

    @Override
    public void initialize(){
        if (drivetrain.isFinished()){
            timer.reset();
            timer.start();
        }
    }

    @Override
    public void execute() {
        intake.intakeOn();
    }
    
    @Override
    public boolean isFinished() {
        if (timer.get() > duration){
            intake.intakeOff();
        }
        return true;
    }
}