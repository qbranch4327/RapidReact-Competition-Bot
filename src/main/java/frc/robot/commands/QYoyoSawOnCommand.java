package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;

public class QYoyoSawOnCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;

    public QYoyoSawOnCommand(GoldenPP7Subsystem shooter){
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        this.shooter.conveyorOn();
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
