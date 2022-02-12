package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class ShakenNotStirredCommand extends CommandBase {
    private final XboxController controller;
    private final ShakenNotStirredSubsystem intake;

    public ShakenNotStirredCommand(ShakenNotStirredSubsystem intake, XboxController controller){
        this.controller = controller;
        this.intake = intake;
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