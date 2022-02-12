package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.AutonModes.Auto1;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.StopTurretCommand;
import frc.robot.commands.TurnTurretCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController controller;
  private final DrivetrainSubsystem driveTrain;
  private final ClimbSubsystem climb;
  private final IntakeSubsystem intake;
  private final ShooterSubsystem shooter;
  private final VisionSubsystem vision;
  
  private final Command m_autoCommand;
  


  // The robot's subsystems and commands are defined here...
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    this.controller = new XboxController(0);
    this.driveTrain = new DrivetrainSubsystem();
    this.climb = new ClimbSubsystem();
    this.intake = new IntakeSubsystem();
    this.vision = new VisionSubsystem();
    this.shooter = new ShooterSubsystem(vision);
    
    this.m_autoCommand = new Auto1(driveTrain);
    
    driveTrain.setDefaultCommand(new DriveCommand(driveTrain,controller));
    climb.setDefaultCommand(new ClimbCommand(climb, controller));
    intake.setDefaultCommand(new IntakeCommand(intake, controller));
    shooter.setDefaultCommand(new ShooterCommand(shooter, controller, vision));


    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Button visionButton = new JoystickButton(controller, XboxController.Button.kBack.value);
    visionButton
      .whenPressed(new TurnTurretCommand(shooter))
      .whenReleased(new StopTurretCommand(shooter));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
