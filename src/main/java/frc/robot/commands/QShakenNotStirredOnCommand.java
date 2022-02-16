package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QShakenNotStirredOnCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;

    public QShakenNotStirredOnCommand(ShakenNotStirredSubsystem intake){
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.intakeOn();
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}