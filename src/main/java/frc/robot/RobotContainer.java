package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.QSkyHookCommand;
import frc.robot.QAIModes.QAI1;
import frc.robot.commands.AMDB5Command;
import frc.robot.commands.ShakenNotStirredCommand;
import frc.robot.commands.GoldenPP7Command;
import frc.robot.commands.QSpikeFanOffCommand;
import frc.robot.commands.QSpikeFanOnCommand;
import frc.robot.subsystems.SkyHookSubsystem;
import frc.robot.subsystems.AMDB5Subsystem;
import frc.robot.subsystems.ShakenNotStirredSubsystem;
import frc.robot.subsystems.GoldenPP7Subsystem;
import frc.robot.subsystems.MoonRakerSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController controller;
  private final AMDB5Subsystem driveTrain;
  private final SkyHookSubsystem climb;
  private final ShakenNotStirredSubsystem intake;
  private final GoldenPP7Subsystem shooter;
  private final MoonRakerSubsystem vision;
  
  private final Command m_autoCommand;
  


  // The robot's subsystems and commands are defined here...
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    this.controller = new XboxController(0);
    this.driveTrain = new AMDB5Subsystem();
    this.climb = new SkyHookSubsystem();
    this.intake = new ShakenNotStirredSubsystem();
    this.vision = new MoonRakerSubsystem();
    this.shooter = new GoldenPP7Subsystem(vision);
    
    this.m_autoCommand = new QAI1(driveTrain);
    
    driveTrain.setDefaultCommand(new AMDB5Command(driveTrain,controller));
    climb.setDefaultCommand(new QSkyHookCommand(climb, controller));
    intake.setDefaultCommand(new ShakenNotStirredCommand(intake, controller));
    shooter.setDefaultCommand(new GoldenPP7Command(shooter, controller, vision));


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
      .whenPressed(new QSpikeFanOnCommand(shooter, vision))
      .whenReleased(new QSpikeFanOffCommand(shooter));
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
