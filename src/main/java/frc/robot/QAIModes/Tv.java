package frc.robot.QAIModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class Tv extends SequentialCommandGroup{
    public Tv(DriveSubsystem drive) {
        addCommands(
          new AutonEncoderDriveCommand(drive, 6, .2)
        );
      }
}
