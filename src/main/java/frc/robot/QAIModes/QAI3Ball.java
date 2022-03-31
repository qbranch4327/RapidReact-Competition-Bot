package frc.robot.QAIModes;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

public class QAI3Ball extends SequentialCommandGroup{

    private final double distance1 = 20;
    private final double distance2 = -40;
    private final double distance3 = 190;
    private final double distance4 = 190;
    private final double intialstart = 0;
    private final double intakedurationTime = 3;
    private final double intake1startTime = .75;
    private final double conveyor1startTime = 2;
    private final double shooter1endTime = 4;
    private final double drive2startTime = 4;
    private final double intake2startTime = 8;
    private final double shooter2startTime = 8;
    private final double conveyor2startTime = 10;
    private final double shooter2endTime = 12;
    private final double drive3startTime = 5;
    private final double drive4startTime = 10;


    public QAI3Ball(AMDB5Subsystem drive, GoldenPP7Subsystem shooter, MoonRakerSubsystem vision, ShakenNotStirredSubsystem intake){
        addCommands(
            new Q3Commands(drive, vision, shooter, intake, distance1, distance2, distance3, distance4, intialstart, intakedurationTime, intake1startTime, conveyor1startTime, shooter1endTime, drive2startTime, intake2startTime, shooter2startTime, conveyor2startTime, shooter2endTime, drive3startTime, drive4startTime));
    }
}
