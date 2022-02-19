package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShakenNotStirredSubsystem;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class QShakenNotStirredOnCommand extends CommandBase {
    private final ShakenNotStirredSubsystem intake;
    private final WaitCommand intakeSpinningTime = new WaitCommand(5);
    private QAMDB5Command drivetrain;

    public QShakenNotStirredOnCommand(ShakenNotStirredSubsystem intake, QAMDB5Command drivetrain){
        this.intake = intake;
        this.drivetrain = drivetrain;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        if (drivetrain.isFinished()){
            intake.intakeOn();
            intakeSpinningTime.initialize();
            intakeSpinningTime.execute();
            SmartDashboard.putString("intake spinning time:", intakeSpinningTime.toString());
            if (intakeSpinningTime.isFinished()){
                intake.intakeOff();
            }
        }
    }
    
    @Override
    public boolean isFinished() {
        return true;
    }
}