package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends CommandBase {
    private final XboxController controller;
    private final ClimbSubsystem climber;

    public ClimbCommand(ClimbSubsystem climber, XboxController controller){
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