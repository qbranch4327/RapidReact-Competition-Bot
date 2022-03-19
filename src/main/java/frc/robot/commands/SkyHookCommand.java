package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkyHookSubsystem;
import edu.wpi.first.wpilibj.Joystick;

public class SkyHookCommand extends CommandBase {
    private final Joystick rightJoystick;
    private final SkyHookSubsystem climber;

    public SkyHookCommand(SkyHookSubsystem climber, Joystick rightJoystick) {
        this.climber = climber;
        this.rightJoystick = rightJoystick;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        this.climber.setspeed(getSpeed());
    }

    private double getSpeed() {
        if (rightJoystick.getRawButton(4)) {
            return 1.0d;
        }

        if (rightJoystick.getRawButton(5)) {
            return -1.0d;
        }

        return 0d;
    }
}