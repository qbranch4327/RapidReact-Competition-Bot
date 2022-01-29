package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveDistanceCommand extends CommandBase{
    private final DrivetrainSubsystem drive;
    private final double distance;
    private final Encoder leftEncoder;
    private final Encoder rightEncoder;


    public DriveDistanceCommand(DrivetrainSubsystem drive, double distance){
        this.drive = drive;
        this.distance = distance;
        this.leftEncoder = new Encoder(0,1);
        this.rightEncoder = new Encoder(2,3);
        addRequirements(drive);

    }
    @Override
    public void initialize() {
        this.leftEncoder.reset();
        this.rightEncoder.reset();
    }

    @Override
    public void execute(){
        drive.setSpeed(0.2, 0.2);
    }

    @Override
    public boolean isFinished() {
        
       var leftDistance = this.leftEncoder.getDistance();
       var rightDistance = this.rightEncoder.getDistance();

        return leftDistance >= this.distance || rightDistance >= this.distance;
    }

}
