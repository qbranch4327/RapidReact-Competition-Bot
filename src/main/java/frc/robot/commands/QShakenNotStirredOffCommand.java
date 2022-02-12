package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class QShakenNotStirredOffCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;

    public QShakenNotStirredOffCommand(ShakenNotStirredSubsystem intake){
        this.intake = intake;
    }

    @Override
    public void execute() {
        intake.intakeOff();
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}