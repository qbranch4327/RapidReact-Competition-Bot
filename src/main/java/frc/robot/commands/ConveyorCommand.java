package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ConveyorCommand extends CommandBase {
    private final ShooterSubsystem shooter;

    public ConveyorCommand(ShooterSubsystem shooter){
        this.shooter = shooter;
    }

    @Override
    public void execute(){
        shooter.conveyorOn();
        }

    @Override
    public void finalize(){
        shooter.conveyorOff();
    }

}
