package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.QAMDB5Command;
//import frc.robot.commands.Spinnies;
import frc.robot.subsystems.AMDB5Subsystem;

/**
 * A complex auto command that drives forward, releases a hatch, and then drives
 * backward.
 */
public class QAI1 extends SequentialCommandGroup {
    /**
     * Creates a new ComplexAuto.
     *
     * @param drive The drive subsystem this command will run on
     * @param hatch The hatch subsystem this command will run on
     */
    public QAI1(AMDB5Subsystem drive) {
        addCommands(
            new QAMDB5Command(drive, 82.17, .5),
            // backwards
            new QAMDB5Command(drive, -82.17, -.5)
        // shoot balls

        );
    }
}