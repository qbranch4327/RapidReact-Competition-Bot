package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class TurnTurretCommand extends CommandBase {
    private final ShooterSubsystem shooter;
    public TurnTurretCommand(ShooterSubsystem shooter) {
        this.shooter = shooter;

    }
    @Override
    public void initialize(){
        this.shooter.turretCCW();
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
