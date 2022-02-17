package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;

public class GoldenPP7Command extends CommandBase {
    private final XboxController controller1;
    private final XboxController controller2;
    private final GoldenPP7Subsystem shooter;
    private MoonRakerSubsystem vision = null;

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

    public GoldenPP7Command(GoldenPP7Subsystem shooter, XboxController controller1, XboxController controller2, MoonRakerSubsystem vision){
        this.shooter = shooter;
        this.controller1 = controller1;
        this.controller2 = controller2;
        this.vision = vision;
        addRequirements(shooter);
        addRequirements(vision);
    }

    public GoldenPP7Command(GoldenPP7Subsystem shooter, XboxController controller1, XboxController controller2){
        this.shooter = shooter;
        this.controller1 = controller1;
        this.controller2 = controller2;
        addRequirements(shooter);
    }

    @Override
    public void execute(){
        // shooter.update();

        // if (vision.getDistance() < d1){
        //     velocity = ips1;
        //     //add indexer command
        // }
        // else if (vision.getDistance() > d1 && vision.getDistance() < d2){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d2 && vision.getDistance() < d3){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d3 && vision.getDistance() < d4){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d4 && vision.getDistance() < d5){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d5 && vision.getDistance() < d6){
        //     velocity = ips1;
        // }
        // else if (vision.getDistance() > d6 && vision.getDistance() < d7){
        //     velocity = ips2;
        // }
        // else {
        //     velocity = ips3;
        // }

        // if (controller1.getLeftBumper()){
        //     shooter.indexer80();
        // }
        // else {
        //     shooter.indexer60();
        // }

        if (controller2.getAButton()){
            shooter.shooterOn(velocity);
        }
        else {
            shooter.shooterOff();
        }
        
        if (controller2.getXButton()){
            shooter.conveyor1On();
        }
        else {
            shooter.conveyor1Off();
        }

        if (controller1.getXButton()){
            shooter.conveyor2On();

        }
        else {
            shooter.conveyor2Off();

        }
        
        if (controller2.getBButton()){
            shooter.turretCW();
        }
        
        else if (controller2.getYButton()){
            shooter.turretCCW();
        }
        else {
            shooter.turretOff();
        }

        // if (vision.getX() < -5){
        //     shooter.turretCCW(vision.getX());
        // }
        // else if (vision.getX() > 5){
        //     shooter.turretCW(vision.getX());
        // }
        // else {
        //     shooter.turretOff();;
        // }
    }
}
