package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.QAMDB5Command;
import frc.robot.commands.QGoldenPP7OnCommand;
import frc.robot.commands.QShakenNotStirredCommand;
import frc.robot.commands.QYoyoSawCommand;
import frc.robot.subsystems.AMDB5Subsystem;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;
import frc.robot.subsystems.ShakenNotStirredSubsystem;

/**
 * A complex auto command that drives forward, releases a hatch, and then drives
 * backward.
 */
public class QAI2 extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param hatch The hatch subsystem this command will run on
   */
  public QAI2(AMDB5Subsystem drive, ShakenNotStirredSubsystem intake, MoonRakerSubsystem vision, GoldenPP7Subsystem shooter) {
    addCommands(
      new QYoyoSawCommand(shooter, 5, .2),
      new QAMDB5Command(drive, 40.75, .3),
      new QShakenNotStirredCommand(intake, 4),
      new QAMDB5Command(drive, -40.75, .2),
      new QYoyoSawCommand(shooter, 5, 3)
      
    );
  }
}