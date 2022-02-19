package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.AMDB5Subsystem;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


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

    

    public QAI1(AMDB5Subsystem drive, ShakenNotStirredSubsystem intake, MoonRakerSubsystem vision, GoldenPP7Subsystem shooter) {
        QAMDB5Command driving = new QAMDB5Command(drive, 40.75, .5);
        QShakenNotStirredOnCommand intaking = new QShakenNotStirredOnCommand(intake, driving);
        addCommands(
            driving,
            intaking,
            //new QSpikeFanOnCommand(shooter, vision),
            new QGoldenPP7OnCommand(shooter,intaking),
            new QYoyoSawOnCommand(shooter, intaking)
        );
    }
}