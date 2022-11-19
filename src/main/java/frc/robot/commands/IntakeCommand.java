package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class IntakeCommand extends CommandBase {
    private final XboxController controller;
    private final IntakeSubsystem intake;
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;

    public IntakeCommand(IntakeSubsystem intake, Joystick leftJoystick, Joystick rightJoystick, XboxController controller){
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
        else if (controller.getRightY()>.1){
            intake.intakeOn(false);
        }
        else if (controller.getRightY()< -.1){
            intake.intakeOn(true);
        }
        else {
            intake.intakeOff();
        }
        
    }
}