package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkyHookSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class SkyHookCommand extends CommandBase {
    private final Joystick rightJoystick;
    private final SkyHookSubsystem climber;
    private final XboxController controller;

    public SkyHookCommand(SkyHookSubsystem climber, Joystick rightJoystick, XboxController controller2) {
        this.climber = climber;
        this.rightJoystick = rightJoystick;
        this.controller = controller2;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        if (rightJoystick.getRawButton(4)) {
            climber.setRspeed(1);
            climber.setLspeed(1);
        }
        else if (rightJoystick.getRawButton(5)) {
            climber.setRspeed(-1);
            climber.setLspeed(-1);
        }
        else {
            climber.setRspeed(0);
            climber.setLspeed(0);
        }

       if (controller.getYButton()) {
           climber.setLspeed(1);
       }
       else if (controller.getBButton()) {
           climber.setLspeed(-1);
       }
       else {
           climber.setLspeed(0);
       }
    }
}