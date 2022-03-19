package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;

public class QAMDB5Command extends CommandBase {
    private final AMDB5Subsystem drive;
    private final double distance;
    private final double speed;
    private boolean backward = false;
    private double leftDistance;
    private double rightDistance;

    public QAMDB5Command(AMDB5Subsystem drive, double distance, double speed) {
        this.drive = drive;
        this.distance = -distance;
        this.speed = speed;
        if (this.distance < 0){
            this.backward = true;
        }
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
        if (!backward){
            drive.setSpeed(speed, speed+.0075);
        }
        else if (backward){
            drive.setSpeed(-speed, -speed-.0075);
        }
        leftDistance = drive.getLeftEncoderDistanceInches();
        rightDistance = drive.getRightEncoderDistanceInches();

        System.out.println("left: " + leftDistance);
        System.out.println("right: " + rightDistance);

    }

    @Override
    public boolean isFinished() {
        drive.publishToDashboard();
        if (backward){
            if (leftDistance <= this.distance || rightDistance <= this.distance){
                drive.setSpeed(0, 0);
                drive.switchToCoastMode();
                return leftDistance <= this.distance || rightDistance <= this.distance;
            }
        }
        if (!backward){
            if (leftDistance >= this.distance || rightDistance >= this.distance){
                drive.setSpeed(0, 0);
                drive.switchToCoastMode();
                return leftDistance >= this.distance || rightDistance >= this.distance;
            }
        }
        return false;
    }
}
