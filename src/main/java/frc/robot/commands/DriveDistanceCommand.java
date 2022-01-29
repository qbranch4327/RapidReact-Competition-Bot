package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveDistanceCommand extends CommandBase {
    private final DrivetrainSubsystem drive;
    private final double distance;
    private final Encoder leftEncoder;
    private final Encoder rightEncoder;

    public DriveDistanceCommand(DrivetrainSubsystem drive, double distance) {
        System.out.println("DriveDistanceCommand constructor");
        this.drive = drive;
        this.distance = distance;
        this.leftEncoder = new Encoder(0, 1);
        this.rightEncoder = new Encoder(2, 3);
        addRequirements(drive);

    }

    @Override
    public void initialize() {
        System.out.println("DriveDistanceCommand initialize");
        this.leftEncoder.reset();
        this.rightEncoder.reset();
    }

    @Override
    public void execute() {
        System.out.println("DriveDistanceCommand execute");
        drive.setSpeed(0.2, 0.2);
    }

    @Override
    public boolean isFinished() {
        System.out.println("DriveDistanceCommand isFinished");
        var leftDistance = this.leftEncoder.getDistance();
        System.out.println("leftDistance: " + leftDistance);

        var rightDistance = this.rightEncoder.getDistance();
        System.out.println("rightDistance: " + rightDistance);

        return false; // leftDistance >= this.distance || rightDistance >= this.distance;
    }

}
