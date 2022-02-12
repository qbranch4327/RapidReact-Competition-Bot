package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;

public class QSpikeFanOnCommand extends CommandBase {
    
    private final GoldenPP7Subsystem shooter;
    private final MoonRakerSubsystem vision;

    public QSpikeFanOnCommand(GoldenPP7Subsystem shooter, MoonRakerSubsystem vision) {
        this.shooter = shooter;
        this.vision = vision;

    }
    @Override
    public void initialize(){
        if (vision.getX() < -5){
            shooter.turretCCW(vision.getX());
        }
        else if (vision.getX() > 5){
            shooter.turretCW(vision.getX());
        }
        else {
            shooter.turretOff();;
        }
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
