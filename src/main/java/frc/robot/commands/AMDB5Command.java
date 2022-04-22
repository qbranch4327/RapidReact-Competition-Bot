package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AMDB5Subsystem;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;

public class AMDB5Command extends CommandBase {
    private final Joystick leftJoystick;
    private final Joystick rightJoystick;
    private final AMDB5Subsystem drivetrain;
    private final XboxController controller;

    public AMDB5Command(AMDB5Subsystem drivetrain, Joystick leftJoystick, Joystick rightJoystick, XboxController controller){
        this.drivetrain = drivetrain;
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        this.controller = controller;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize(){
        drivetrain.resetEncoders();
    }

    @Override
    public void execute(){
        double percentLeft = leftJoystick.getY();
        double percentRight = rightJoystick.getY();
        percentLeft *= .65;
        percentRight *= .65;

        this.drivetrain.publishToDashboard();
        this.drivetrain.setSpeed(percentRight,percentLeft);
    }
}
