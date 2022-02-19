package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GoldenPP7Subsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class QYoyoSawOnCommand extends CommandBase{
    private final GoldenPP7Subsystem shooter;
    private final WaitCommand conveyorTime = new WaitCommand(6);
    private final WaitCommand middleTime = new WaitCommand(2);
    private QShakenNotStirredOnCommand intake;

    public QYoyoSawOnCommand(GoldenPP7Subsystem shooter, QShakenNotStirredOnCommand intake){
        this.shooter = shooter;
        this.intake = intake;
        addRequirements(shooter);
    }

    @Override
    public void initialize(){
        if (intake.isFinished()){
            shooter.conveyor1On();
            middleTime.initialize();
            middleTime.execute();
            SmartDashboard.putString("conveyor time: ", conveyorTime.toString());
            if (middleTime.isFinished()){
                shooter.conveyor2On();
            }
            if (conveyorTime.isFinished()){
                shooter.conveyor1Off();
                shooter.conveyor2Off();
            }
        }
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
