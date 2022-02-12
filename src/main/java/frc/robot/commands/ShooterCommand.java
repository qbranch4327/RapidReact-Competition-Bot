package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class ShooterCommand extends CommandBase {
    private final XboxController controller;
    private final ShooterSubsystem shooter;
    private final VisionSubsystem vision;

    private final double d1 = 1;
    private final double d2 = 2;
    private final double d3 = 3;
    private final double d4 = 4;
    private final double d5 = 5;
    private final double d6 = 6;
    private final double d7 = 7;

    private final double ips1 = 400;
    private final double ips2 = 700;
    private final double ips3 = 800;

    private double velocity;

    public ShooterCommand(ShooterSubsystem shooter, XboxController controller, VisionSubsystem vision){
        this.shooter = shooter;
        this.controller = controller;
        this.vision = vision;
        addRequirements(shooter);
    }

    @Override
    public void execute(){
        shooter.update();

        if (vision.getDistance() < d1){
            velocity = ips1;
            //add indexer command
        }
        else if (vision.getDistance() > d1 && vision.getDistance() < d2){
            velocity = ips1;
        }
        else if (vision.getDistance() > d2 && vision.getDistance() < d3){
            velocity = ips1;
        }
        else if (vision.getDistance() > d3 && vision.getDistance() < d4){
            velocity = ips1;
        }
        else if (vision.getDistance() > d4 && vision.getDistance() < d5){
            velocity = ips1;
        }
        else if (vision.getDistance() > d5 && vision.getDistance() < d6){
            velocity = ips1;
        }
        else if (vision.getDistance() > d6 && vision.getDistance() < d7){
            velocity = ips2;
        }
        else {
            velocity = ips3;
        }

        if (controller.getLeftBumper()){
            shooter.indexer80();
        }
        else {
            shooter.indexer60();
        }

        if (controller.getAButton()){
            shooter.shooterOn(velocity);
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

        if (vision.getX() < -5){
            shooter.turretCCW(vision.getX());
        }
        else if (vision.getX() > 5){
            shooter.turretCW(vision.getX());
        }
        else {
            shooter.turretOff();;
        }
    }
}
