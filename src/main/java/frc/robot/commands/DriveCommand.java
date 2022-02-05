package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends CommandBase {
    private final XboxController controller;
    private final DrivetrainSubsystem drivetrain;

    public DriveCommand(DrivetrainSubsystem drivetrain, XboxController controller){
        this.drivetrain = drivetrain;
        this.controller = controller;
        addRequirements(drivetrain);
    }

    @Override
    public void execute(){
        var percentLeft = controller.getLeftY();
        var percentRight = controller.getRightY();
        this.drivetrain.publishToDashboard();
        this.drivetrain.setSpeed(percentRight,percentLeft);
    }
}
