package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class QAI3Ball extends SequentialCommandGroup{
    public QAI3Ball(AMDB5Subsystem drive, GoldenPP7Subsystem shooter, MoonRakerSubsystem vision, ShakenNotStirredSubsystem intake){
        addCommands(
            new QAMDB5Command(drive, 20, .35, shooter, vision),
            new QShakenNotStirredCommand(intake, 2),
            new QAMDB5Command(drive, -60.75, .35, shooter, vision),
            new QGoldenPP7Command(shooter, 5, 2),
            new QDonutCommand(drive, true, 45),
            new QAMDB5Command(drive, 80, .4, shooter, vision),
            new QShakenNotStirredCommand(intake, 2),
            new QDonutCommand(drive, false, 90),
            new QAMDB5Command(drive, 60, .4, shooter, vision),
            new QGoldenPP7Command(shooter, 3, 2)
        );
    }
}
