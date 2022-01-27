package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyorSubsystem;

public class ConveyorCommand extends CommandBase{
    private final XboxController controller;
    private final ConveyorSubsystem conveyor;

    public ConveyorCommand(ConveyorSubsystem conveyor, XboxController controller){
        this.controller = controller;
        this.conveyor = conveyor;
    }

    @Override
    public void execute(){
        if (controller.getAButtonPressed()){
            this.conveyor.start();
        }
        else{
            this.conveyor.stop();
        }
    }
 
}
