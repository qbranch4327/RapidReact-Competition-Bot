package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.QAMDB5Command;
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
    drive.switchToBrakeMode();
    addCommands(
      new QYoyoSawCommand(shooter, 4, 2),
      new QAMDB5Command(drive, 20, .3),
      new QShakenNotStirredCommand(intake, 2.5),
      new QAMDB5Command(drive, -50.75, .2),
      new QYoyoSawCommand(shooter, 4, 2)
    );
    drive.switchToCoastMode();
  }
}