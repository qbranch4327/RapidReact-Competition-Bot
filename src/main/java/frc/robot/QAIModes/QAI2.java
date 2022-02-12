package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.QAMDB5Command;
import frc.robot.subsystems.AMDB5Subsystem;

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
  public QAI2(AMDB5Subsystem drive) {
    addCommands(
        // forward zoomies the specified distance
        new QAMDB5Command(drive, 12, .5),

        // Spinnies
        // new SpinDegrees(),

        // backward zoomies the specified distance
        new QAMDB5Command(drive, -12, .5)

    );
  }
}