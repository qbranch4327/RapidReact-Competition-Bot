package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import com.ctre.phoenix.music.Orchestra;

public class DriveCommand extends CommandBase {
    private final XboxController controller;
    private final DrivetrainSubsystem drivetrain;
    private final Orchestra player = new Orchestra();

    public DriveCommand(DrivetrainSubsystem drivetrain, XboxController controller){
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
        if (controller.getAButton()){
            player.loadMusic("C:/Users/Jburd/Documents/RapidReact-Competition-Bot/src/main/deploy/song1.chrp");
            player.play();
        }
        // if (controller.getXButton()){
        //     player.loadMusic("C:/Users/Jburd/Documents/RapidReact-Competition-Bot/src/main/deploy/songwii.chrp");
        //     player.play();
        // }
    }
}
