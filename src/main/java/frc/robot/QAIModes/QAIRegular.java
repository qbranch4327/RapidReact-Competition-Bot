package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


/**
 * A complex auto command that drives forward, releases a hatch, and then drives
 * backward.
 */
public class QAIRegular extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param hatch The hatch subsystem this command will run on
   */
  public QAIRegular(DriveSubsystem drive, IntakeSubsystem intake, VisionSubsystem vision, ShooterSubsystem shooter) {
    addCommands(
      new AutonShooterCommand(shooter, 5, 3),
      new AutonDriveCommand(drive, 20, .25, shooter, vision),
      new AutonIntakeCommand(intake, 2.5),
      new AutonDriveCommand(drive, -40.75, .2, shooter, vision),
      new AutonShooterCommand(shooter, 5, 3)
    );
  }
}