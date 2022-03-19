package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;

public class QDonutCommand extends CommandBase{
    private final AMDB5Subsystem drivetrain;
    private boolean direction;
    private final double spin = 82.6 / 360;
    private double distance;

    public QDonutCommand(AMDB5Subsystem drivetrain, boolean direction, double degrees){
        this.drivetrain = drivetrain;
        this.direction = direction;
        distance = spin * degrees;
    }

    @Override
    public void initialize(){
        drivetrain.resetEncoders();
        drivetrain.publishToDashboard();
        drivetrain.switchToBrakeMode();
    }

    @Override
    public void execute(){
       if(direction){
           drivetrain.setSpeed(-0.3, 0.3);
       }
       else if(!direction){
           drivetrain.setSpeed(0.3, -0.3);
       }
    }
    @Override
    public boolean isFinished(){
        if(Math.abs(drivetrain.getLeftEncoderDistanceInches()) >= distance || Math.abs(drivetrain.getRightEncoderDistanceInches()) >= distance){
            drivetrain.setSpeed(0, 0);
            drivetrain.switchToCoastMode();
            return true;
        }
        else{
            return false;
        }
    }
}
