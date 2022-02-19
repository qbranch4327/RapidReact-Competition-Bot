package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QShakenNotStirredOnCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;
    private final Timer timer;
    private QAMDB5Command drivetrain;
    private double x;

    public QShakenNotStirredOnCommand(ShakenNotStirredSubsystem intake, QAMDB5Command drivetrain, Timer time, double x){
        this.intake = intake;
        this.drivetrain = drivetrain;
        this.timer = time;
        this.x = x;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        if (drivetrain.isFinished()){
            intake.intakeOn();
            if (timer.get() - x > 6){
                intake.intakeOff();
            }
        }
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}