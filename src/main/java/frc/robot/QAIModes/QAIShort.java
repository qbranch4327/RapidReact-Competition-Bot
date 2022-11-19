package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


/**
 * A complex auto command that drives forward, releases a hatch, and then drives
 * backward.
 */
public class QAIShort extends SequentialCommandGroup {
    /**
     * Creates a new ComplexAuto.
     *
     * @param drive The drive subsystem this command will run on
     * @param hatch The hatch subsystem this command will run on
     */
    public QAIShort(DriveSubsystem drive, IntakeSubsystem intake, VisionSubsystem vision, ShooterSubsystem shooter) {
        addCommands(
            new AutonShooterCommand(shooter, 4, 2),
            new AutonDriveCommand(drive, 14, .3, shooter, vision),
            new AutonIntakeCommand(intake, 2.5),
            new AutonDriveCommand(drive, -28.75, .2, shooter, vision),
            new AutonShooterCommand(shooter, 5, 3)
        );
    }
}