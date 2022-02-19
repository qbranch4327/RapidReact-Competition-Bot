package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;
import com.ctre.phoenix.music.Orchestra;

public class AMDB5Command extends CommandBase {
    private final XboxController controller;
    private final AMDB5Subsystem drivetrain;
    private final Orchestra player = new Orchestra();

    public AMDB5Command(AMDB5Subsystem drivetrain, XboxController controller){
        this.drivetrain = drivetrain;
        this.controller = controller;
        addRequirements(drivetrain);
        player.addInstrument(drivetrain.speaker1());
        player.addInstrument(drivetrain.speaker2());
    }

    @Override
    public void execute(){
        var percentLeft = controller.getLeftY();
        var percentRight = controller.getRightY();
        this.drivetrain.publishToDashboard();
        this.drivetrain.setSpeed(percentRight,percentLeft);
        if (controller.getBButton()){
            player.loadMusic("C:/Users/Jburd/Documents/RapidReact-Competition-Bot/src/main/deploy/song1.chrp");
            player.play();
        }
        // if (controller.getYButton()){
        //     player.loadMusic("C:/Users/Jburd/Documents/RapidReact-Competition-Bot/src/main/deploy/songwii.chrp");
        //     player.play();
        // }
    }
}