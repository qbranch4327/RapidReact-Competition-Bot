package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.AMDB5Subsystem;
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
    public QAIShort(AMDB5Subsystem drive, ShakenNotStirredSubsystem intake, MoonRakerSubsystem vision, GoldenPP7Subsystem shooter) {
        addCommands(
            new QGoldenPP7Command(shooter, 4, 2),
            new QAMDB5Command(drive, 14, .3, shooter, vision),
            new QShakenNotStirredCommand(intake, 2.5),
            new QAMDB5Command(drive, -28.75, .2, shooter, vision),
            new QGoldenPP7Command(shooter, 5, 3)
        );
    }
}