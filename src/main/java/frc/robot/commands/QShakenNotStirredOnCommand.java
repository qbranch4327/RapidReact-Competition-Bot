package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QShakenNotStirredOnCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;
    private final Timer timer = new Timer();
    private QAMDB5Command drivetrain;

    public QShakenNotStirredOnCommand(ShakenNotStirredSubsystem intake, QAMDB5Command drivetrain){
        this.intake = intake;
        this.drivetrain = drivetrain;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        if (drivetrain.isFinished()){
            intake.intakeOn();
            if (timer.get() > 8){
                intake.intakeOff();
            }
        }
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}