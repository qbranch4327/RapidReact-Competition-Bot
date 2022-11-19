package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;
    private final DriveSubsystem drivetrain;

    public DriveCommand(DriveSubsystem drivetrain, Joystick leftJoystick, Joystick rightJoystick, XboxController controller){
        this.drivetrain = drivetrain;
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize(){
        drivetrain.resetEncoders();
    }

    @Override
    public void execute(){
        double percentLeft = leftJoystick.getY();
        double percentRight = rightJoystick.getY();
        percentLeft *= .65;
        percentRight *= .65;

        this.drivetrain.publishToDashboard();
        this.drivetrain.setSpeed(percentRight,percentLeft);
    }
}
