package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkyHookSubsystem;

public class QSkyHookCommand extends CommandBase {
    private final XboxController controller;
    private final SkyHookSubsystem climber;

    public QSkyHookCommand(SkyHookSubsystem climber, XboxController controller){
        this.climber = climber;
        this.controller = controller;
    }

    @Override
    public void execute(){
        var percentUp = controller.getRightTriggerAxis();
        var percentDown = controller.getLeftTriggerAxis();
        this.climber.setspeed(percentUp,percentDown);
    }
}