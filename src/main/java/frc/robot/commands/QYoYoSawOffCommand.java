package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;

public class QYoYoSawOffCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;

    public QYoYoSawOffCommand(GoldenPP7Subsystem shooter){
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        this.shooter.conveyor1Off();
        this.shooter.conveyor2Off();
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
