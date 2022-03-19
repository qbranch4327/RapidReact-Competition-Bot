package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkyHookSubsystem;
import edu.wpi.first.wpilibj.Joystick; 


public class SkyHookCommand extends CommandBase {
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;
    private final SkyHookSubsystem climber;

    public SkyHookCommand(SkyHookSubsystem climber, Joystick leftJoystick, Joystick rightJoystick){
        this.climber = climber;
        this.rightJoystick = rightJoystick;
        this.leftJoystick = leftJoystick;
        addRequirements(climber);
    }

    @Override
    public void execute(){
        var climbSpeedUp = rightJoystick.getRawButton(2);
        var climbSpeedDown = rightJoystick.getRawButton(3);
        this.climber.setspeed(climbSpeedUp,climbSpeedDown);
    }
}