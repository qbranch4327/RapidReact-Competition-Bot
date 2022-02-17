package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class ShakenNotStirredCommand extends CommandBase {
    private final XboxController controller1;
    private final XboxController controller2;
    private final ShakenNotStirredSubsystem intake;

    public ShakenNotStirredCommand(ShakenNotStirredSubsystem intake, XboxController controller1, XboxController controller2){
        this.controller1 = controller1;
        this.controller2 = controller2;
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void execute(){
        if (controller2.getRightBumper()){
            intake.intakeOn();
        }
        else if (controller2.getLeftBumper()){
            intake.intakeUp();
        }
        else{
            intake.intakeOff();
        }
    }
}