package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    private final XboxController controller;
    private final IntakeSubsystem intake;

    public IntakeCommand(IntakeSubsystem intake, XboxController controller){
        this.controller = controller;
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute(){
        if (controller.getRightBumperPressed()){
            intake.intakeOn();
        }
        else{
            intake.intakeOff();
        }
    }
}
