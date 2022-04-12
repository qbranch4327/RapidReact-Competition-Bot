package frc.robot.commands;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

public class ShakenNotStirredCommand extends CommandBase {
    private final XboxController controller;
    private final ShakenNotStirredSubsystem intake;
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;

    public ShakenNotStirredCommand(ShakenNotStirredSubsystem intake, Joystick leftJoystick, Joystick rightJoystick, XboxController controller){
        this.controller = controller;
        this.intake = intake;
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        addRequirements(intake);
    }

    @Override
    public void execute(){
        if (leftJoystick.getRawButton(1)){
            intake.intakeOn(false);
        }
        else if (rightJoystick.getRawButton(1)){
            intake.intakeOn(true);
        }
        else if (rightJoystick.getRawButton(2)){
            intake.intakeUp();
        }
        else {
            intake.intakeOff();
        }
    }
}