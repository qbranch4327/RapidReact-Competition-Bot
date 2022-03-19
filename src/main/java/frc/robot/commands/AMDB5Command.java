package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;
import com.ctre.phoenix.music.Orchestra;

public class AMDB5Command extends CommandBase {
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;
    private final AMDB5Subsystem drivetrain;
    private final Orchestra player = new Orchestra();

    public AMDB5Command(AMDB5Subsystem drivetrain, Joystick leftJoystick, Joystick rightJoystick){
        this.drivetrain = drivetrain;
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        addRequirements(drivetrain);
        player.addInstrument(drivetrain.speaker1());
        player.addInstrument(drivetrain.speaker2());
    }

    @Override
    public void initialize(){
        drivetrain.resetEncoders();
    }

    @Override
    public void execute(){
        double percentLeft = leftJoystick.getY();
        double percentLeft = rightJoystick.getY();
        percentLeft *= .6;
        percentRight *= .6;

        this.drivetrain.publishToDashboard();
        this.drivetrain.setSpeed(percentRight,percentLeft);
        
        // if (controller.getBButton()){
        //     if (player.isPlaying()){
        //         player.stop();
        //     }
        //     else{
        //         player.loadMusic("src/main/deploy/song1.chrp");
        //         player.play();
        //     }
        // }
        // if (controller.getYButton()){
        //     if (player.isPlaying()){
        //         player.stop();
        //     }
        //     else{
        //         player.loadMusic("src/main/deploy/songwii.chrp");
        //         player.play();
        //     }
        // }
    }
}
