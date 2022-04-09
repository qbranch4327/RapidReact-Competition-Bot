package frc.robot.QAIModes;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;

public class QAI3Ball extends SequentialCommandGroup{

    private final double distance1 = -35;
    private final double distance2 = 20;
    private final double distance3 = -60;
    private final double distance4 = 60;
    private final double intialstart = 0;
    private final double intakedurationTime = 3;
    private final double intake1startTime = 1;
    private final double conveyor1startTime = 5;
    private final double shooter1endTime = 8;
    private final double drive2startTime = 3.25;
    private final double intake2startTime = 8;
    private final double shooter2startTime = 8;
    private final double conveyor2startTime = 14;
    private final double shooter2endTime = 15;
    private final double drive3startTime = 7;
    private final double drive4startTime = 13;
    private final double drive4endTime = 15;


    public QAI3Ball(AMDB5Subsystem drive, GoldenPP7Subsystem shooter, MoonRakerSubsystem vision, ShakenNotStirredSubsystem intake){
        addCommands(
            new Q3Commands(drive, vision, shooter, intake, distance1, distance2, distance3, distance4, intialstart, intakedurationTime, intake1startTime, conveyor1startTime, shooter1endTime, drive2startTime, intake2startTime, shooter2startTime, conveyor2startTime, shooter2endTime, drive3startTime, drive4startTime, drive4endTime));
    }
}
