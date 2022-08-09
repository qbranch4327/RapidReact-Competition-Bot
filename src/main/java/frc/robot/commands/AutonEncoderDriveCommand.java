package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


public class AutonEncoderDriveCommand extends CommandBase {
    private final DriveSubsystem drive;
    private final double distance;
    private final double speed;
    private double leftDistance;
    private double rightDistance;

    public AutonEncoderDriveCommand(DriveSubsystem drive, double distance, double speed) {
        this.drive = drive;
        this.distance = -distance;
        this.speed = -speed;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.resetEncoders();
        drive.publishToDashboard();
        drive.switchToBrakeMode();
    }

    @Override
    public void execute() {
        drive.publishToDashboard();
        drive.setSpeed(speed-.02, speed+.08);

        leftDistance = drive.getLeftEncoderDistanceInches();
        rightDistance = drive.getRightEncoderDistanceInches();

        System.out.println("left: " + leftDistance);
        System.out.println("right: " + rightDistance);
    }

    @Override
    public boolean isFinished() {
        drive.publishToDashboard();
        if (leftDistance <= this.distance || rightDistance <= this.distance){
            drive.setSpeed(0, 0);
            drive.switchToCoastMode();
            return leftDistance >= this.distance || rightDistance >= this.distance;
        }
        return false;
    }
}
