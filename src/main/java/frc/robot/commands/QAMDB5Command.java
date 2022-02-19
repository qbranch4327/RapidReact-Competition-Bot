package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;

public class QAMDB5Command extends CommandBase {
    private final AMDB5Subsystem drive;
    private final double distance;
    private final double speed;
    private boolean backward = false;

    public QAMDB5Command(AMDB5Subsystem drive, double distance, double speed) {
        this.drive = drive;
        this.distance = distance;
        this.speed = speed;
        if (distance < 0){
            this.backward = true;
        }

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.resetEncoders();
        drive.publishToDashboard();
    }

    @Override
    public void execute() {
        if (this.distance > 0){
            drive.setSpeed(speed, speed);
        }
        else if (this.distance < 0){
            drive.setSpeed(speed, speed);
        }
    }

    @Override
    public boolean isFinished() {
<<<<<<< HEAD
        var leftDistance = drive.getLeftEncoderDistanceInches();
        var rightDistance = drive.getRightEncoderDistanceInches();
=======
        var leftDistance = this.drive.getLeftEncoderDistanceInches();
        var rightDistance = this.drive.getRightEncoderDistanceInches();
        System.out.println("left: " + leftDistance);
        System.out.println("right: " + rightDistance);
>>>>>>> 943a9200a554c9664d5b051e49026f417998525e
        if (backward){
            return leftDistance <= this.distance || rightDistance <= this.distance;
        }
        else {
            return leftDistance >= this.distance || rightDistance >= this.distance;
        }
    }
}
