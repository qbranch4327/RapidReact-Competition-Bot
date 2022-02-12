package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;

public class QDonutAMBD5Command extends CommandBase {

    private final AMDB5Subsystem drivetrain;

    public QDonutAMBD5Command(AMDB5Subsystem drivetrain, double distance) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        this.drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        this.drivetrain.setSpeed(.25, -.25); //pos, neg for right - neg, pos for left
    }

    @Override
    public boolean isFinished() {
        var distance = this.drivetrain.getRightEncoderDistanceInches();
        return Math.abs(distance) >= 20;
    }
}
