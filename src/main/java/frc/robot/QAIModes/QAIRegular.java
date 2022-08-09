package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.QDriveCommand;
import frc.robot.commands.QShakenNotStirredCommand;
import frc.robot.commands.QGoldenPP7Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

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
  public QAIRegular(DriveSubsystem drive, ShakenNotStirredSubsystem intake, MoonRakerSubsystem vision, GoldenPP7Subsystem shooter) {
    addCommands(
      new QGoldenPP7Command(shooter, 5, 3),
      new QDriveCommand(drive, 20, .25, shooter, vision),
      new QShakenNotStirredCommand(intake, 2.5),
      new QDriveCommand(drive, -40.75, .2, shooter, vision),
      new QGoldenPP7Command(shooter, 5, 3)
    );
  }
}