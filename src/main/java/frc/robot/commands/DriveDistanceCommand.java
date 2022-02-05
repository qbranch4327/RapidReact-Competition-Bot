package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveDistanceCommand extends CommandBase {
    private final DrivetrainSubsystem drive;
    private final double distance;

    public DriveDistanceCommand(DrivetrainSubsystem drive, double distance) {
        this.drive = drive;
        this.distance = distance;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        this.drive.resetEncoders();
    }

    @Override
    public void execute() {
        drive.setSpeed(0.1, 0.1);
    }

    @Override
    public boolean isFinished() {
        var leftDistance = this.drive.getLeftEncoderDistanceInches();
        var rightDistance = this.drive.getRightEncoderDistanceInches();

        return leftDistance >= this.distance || rightDistance >= this.distance;
    }
}
