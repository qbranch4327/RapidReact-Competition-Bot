package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;

public class YoYoSawCommand extends CommandBase {
    private final GoldenPP7Subsystem shooter;

    public YoYoSawCommand(GoldenPP7Subsystem shooter){
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute(){
        shooter.conveyor1On();
        shooter.conveyor2On();
    }

    @Override
    public void finalize(){
        shooter.conveyor1Off();
        shooter.conveyor2Off();
    }

}
