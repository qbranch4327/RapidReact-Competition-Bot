package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {
    private final XboxController controller;
    private final ShooterSubsystem shooter;

    public ShooterCommand(ShooterSubsystem shooter, XboxController controller){
        this.shooter = shooter;
        this.controller = controller;
        addRequirements(shooter);
    }

    @Override
    public void execute(){
        if (controller.getLeftBumper()){
            shooter.indexer80();
        }
        else {
            shooter.indexer60();
        }
        if (controller.getAButton()){
            shooter.shooterOn(100);
        }
        else {
            shooter.shooterOff();
        }
        if (controller.getXButton()){
            shooter.conveyorOn();
        }
        else {
            shooter.conveyorOff();
        }
        if (controller.getBButton()){
            shooter.turretCW();
        }
        else {
            shooter.turretOff();
        }
        if (controller.getYButton()){
            shooter.turretCCW();
        }
        else {
            shooter.turretOff();
        }
    }
}
