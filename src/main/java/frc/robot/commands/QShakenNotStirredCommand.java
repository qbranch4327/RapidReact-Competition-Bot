package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QShakenNotStirredCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;

    public QShakenNotStirredCommand(ShakenNotStirredSubsystem intake){
        this.intake = intake;
    }

    @Override
    public void execute() {
        intake.intakeOn();
    }
    
    @Override
    public boolean isFinished() {
        intake.intakeOff();
        return true;
    }
}