// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.commands.ClimbCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController controller = new XboxController(0);
  private final DrivetrainSubsystem driveTrain = new DrivetrainSubsystem();
  private final ClimberSubsystem climber = new ClimberSubsystem();

  // The robot's subsystems and commands are defined here...

  private final NetworkTableInstance Instance = NetworkTableInstance.getDefault();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    NetworkTable table = Instance.getTable("limelight");
    double targetOffsetAngle_Horizontal = table.getEntry("tx").getDouble(0);
    double targetOffsetAngle_Vertical = table.getEntry("ty").getDouble(0);
    double targetArea = table.getEntry("ta").getDouble(0);
    double targetSkew = table.getEntry("ts").getDouble(0);
    configureButtonBindings();

    driveTrain.setDefaultCommand(new DriveCommand(driveTrain,controller));

    climber.setDefaultCommand(new ClimbCommand(climber, controller));
  
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  //}
}
