package frc.robot.commands;

import java.awt.Font;
import javax.swing.JLabel;

import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;

public class GoldenPP7Command extends CommandBase {
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;
    private final XboxController controller2;
    private final GoldenPP7Subsystem shooter;
    private MoonRakerSubsystem vision = null;

    private final double d1 = 66;
    private final double d2 = 88;
    private Orchestra player;
    private double velocity = 1100;

    public GoldenPP7Command(GoldenPP7Subsystem shooter, Joystick leftJoystick, Joystick rightJoystick, XboxController controller2, MoonRakerSubsystem vision){
        this.shooter = shooter;
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        this.controller2 = controller2;
        this.vision = vision;

        var speaker = shooter.speaker1();
        player = new Orchestra();
        player.addInstrument(shooter.speaker1());
        addRequirements(shooter);
        addRequirements(vision);
    }

    public GoldenPP7Command(GoldenPP7Subsystem shooter, Joystick leftJoystick, Joystick rightJoystick, XboxController controller2){
        this.shooter = shooter;
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        this.controller2 = controller2;
        addRequirements(shooter);
    }

    @Override
    public void execute(){
        // var errorCode = player.loadMusic("songwii.chrp");
        // System.out.println(errorCode);
        //     // shooter.musicMode(true);
        //     var errorCode2 = player.play();
        //     System.out.println(errorCode2);
        shooter.tone();

        if (controller2.getRightStickButton()){
            if (player.isPlaying()){
                player.stop();
                // shooter.musicMode(false);
            }
        }

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
            shooter.conveyor1On();
        }
        else{
            shooter.conveyor1Off();
        }

        if (controller2.getRightTriggerAxis() > 0.5){
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
        else if (controller2.getXButton()){
            if (vision.getX() < -3){
                shooter.turretCCW();
            }
            else if (vision.getX() > 3){
                shooter.turretCW();
            }
            else {
                shooter.turretOff();;
            }
        } 
        else {
            shooter.turretOff();
        }

    }
}
