package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class ClimbCommand extends CommandBase {
    private final Joystick rightJoystick;
    private final ClimbSubsystem climber;
    private final XboxController controller;

    public ClimbCommand(ClimbSubsystem climber, Joystick rightJoystick, XboxController controller2) {
        this.climber = climber;
        this.rightJoystick = rightJoystick;
        this.controller = controller2;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        if (rightJoystick.getRawButton(4) || controller.getYButton()) {
            climber.setRspeed(1);
        }
        else if (rightJoystick.getRawButton(5) || controller.getBButton()) {
            climber.setRspeed(-1);
        }
        
        else {
            climber.setRspeed(0);
        }

        if (rightJoystick.getRawButton(4)) {
            climber.setLspeed(-1);
        }
        else if (rightJoystick.getRawButton(5)) {
            climber.setLspeed(1);
        }
        else {
            climber.setLspeed(0);
        }
    }
}