package frc.robot.AutonModes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * A complex auto command that drives forward, releases a hatch, and then drives
 * backward.
 */
public class Auto2 extends SequentialCommandGroup {
    /**
     * Creates a new ComplexAuto.
     *
     * @param drive The drive subsystem this command will run on
     * @param hatch The hatch subsystem this command will run on
     */
    public Auto2(DrivetrainSubsystem drive) {
        addCommands(
                //  forward zoomies the specified distance
                new DriveDistanceCommand(drive, 72),

                // Spinnies
              //  new SpinDegrees(),

                //  backward zoomies the specified distance
                new DriveDistanceCommand(drive, 72)
                
                );
    }
}