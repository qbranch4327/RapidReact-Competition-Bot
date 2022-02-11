package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class StopTurretCommand extends CommandBase {
    private final ShooterSubsystem shooter;
    public StopTurretCommand(ShooterSubsystem shooter) {
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
