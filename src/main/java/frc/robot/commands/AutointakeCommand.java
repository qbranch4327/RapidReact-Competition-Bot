package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class AutointakeCommand extends CommandBase {
    private final IntakeSubsystem intake;

    public AutointakeCommand(IntakeSubsystem intake){
        this.intake = intake;
    }

    }
    @Override
    public void execute() {
        intake.intakeOn();
    }
    
    @Override
    public void isFinished() {
        intake.intakeOff();
    }
}