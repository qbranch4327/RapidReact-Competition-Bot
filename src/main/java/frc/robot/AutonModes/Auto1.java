package frc.robot.AutonModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.Spinnies;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * A complex auto command that drives forward, releases a hatch, and then drives
 * backward.
 */
public class Auto1 extends SequentialCommandGroup {
    /**
     * Creates a new ComplexAuto.
     *
     * @param drive The drive subsystem this command will run on
     * @param hatch The hatch subsystem this command will run on
     */
    public Auto1(DrivetrainSubsystem drive) {
        addCommands(
                // start intake
                // forward to pick up ball
                new DriveDistanceCommand(drive, 82.17),
                // backwards
                new DriveDistanceCommand(drive, -82.17)
                 // shoot balls

        );
    }
}