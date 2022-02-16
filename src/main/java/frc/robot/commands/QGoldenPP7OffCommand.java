package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;

public class QGoldenPP7OffCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;

    public QGoldenPP7OffCommand(GoldenPP7Subsystem shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        this.shooter.shooterOff();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
