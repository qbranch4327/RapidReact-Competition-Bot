package frc.robot.commands;

import java.awt.Font;

import javax.swing.JLabel;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;

public class GoldenPP7Command extends CommandBase {
    private final XboxController controller1;
    private final XboxController controller2;
    private final GoldenPP7Subsystem shooter;
    private MoonRakerSubsystem vision = null;

    private final double d1 = 66;
    private final double d2 = 88;
    
    private double velocity = 800;

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
        vision.update();

        if (vision.getDistance() >= d1 && vision.getDistance() <= d2){
            JLabel label = new JLabel();
            label.setFont(new Font("Serif", Font.PLAIN, 44));
            SmartDashboard.putString("Shooting Status", "GO! GO! GO!");
        }
        else{
            SmartDashboard.putString("Shooting Status", "Wait");
        }

        if (controller2.getAButton()){
            shooter.shooterOn(velocity);
        }
        else {
            shooter.shooterOff();
        }
        
        if (controller2.getLeftY() > 0.09){
            shooter.conveyor1On(false);
        }
        else if (controller2.getLeftY() < -0.09){
            shooter.conveyor1On(true);
        }
        else{
            shooter.conveyor1Off();
        }

        if (controller1.getXButton()){
            shooter.conveyor2On();

        }
        else {
            shooter.conveyor2Off();

        }
        
        if (controller2.getRightBumper()){
            shooter.turretCW();
        }
        
        else if (controller2.getLeftBumper()){
            shooter.turretCCW();
        }
        else {
            shooter.turretOff();
        }

        if (controller2.getYButton()){
            if (vision.getX() < -5){
                shooter.turretCCW();
            }
            else if (vision.getX() > 5){
                shooter.turretCW();
            }
            else {
                shooter.turretOff();;
            }
        }
    }
}
