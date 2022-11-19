package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ConveyorCommand extends CommandBase {
    private final ShooterSubsystem shooter;

    public ConveyorCommand(ShooterSubsystem shooter){
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
