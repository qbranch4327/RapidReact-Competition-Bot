package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;

public class QSpikeFanOffCommand extends CommandBase {
    private final GoldenPP7Subsystem shooter;
    public QSpikeFanOffCommand(GoldenPP7Subsystem shooter) {
        this.shooter = shooter;

    }
    @Override
    public void initialize(){
        this.shooter.turretOff();
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
