package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkyHookSubsystem;

public class SkyHookCommand extends CommandBase {
    private final XboxController controller1;
    private final XboxController controller2;
    private final SkyHookSubsystem climber;

    public SkyHookCommand(SkyHookSubsystem climber, XboxController controller1, XboxController controller2){
        this.climber = climber;
        this.controller1 = controller1;
        this.controller2 = controller2;
        addRequirements(climber);
    }

    @Override
    public void execute(){
        var percentUp = controller2.getRightTriggerAxis();
        var percentDown = controller2.getLeftTriggerAxis();
        this.climber.setspeed(percentUp,percentDown);
    }
}