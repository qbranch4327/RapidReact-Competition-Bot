package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkyHookSubsystem;

public class SkyHookCommand extends CommandBase {
    private final XboxController controller1 = new XboxController(0);
    private final SkyHookSubsystem climber;

    public SkyHookCommand(SkyHookSubsystem climber, XboxController controller1){
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute(){
        var climbSpeedUp = controller1.getRightBumper();
        var climbSpeedDown = controller1.getLeftBumper();
        this.climber.setspeed(climbSpeedUp,climbSpeedDown);
    }
}