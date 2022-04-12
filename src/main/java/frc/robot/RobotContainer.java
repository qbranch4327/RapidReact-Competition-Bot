package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.QAIModes.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController controller2;
  private final Joystick leftJoystick;
  private final Joystick rightJoystick;
  private final AMDB5Subsystem driveTrain;
  private final SkyHookSubsystem climb;
  private final ShakenNotStirredSubsystem intake;
  private final GoldenPP7Subsystem shooter;
  private final MoonRakerSubsystem vision;
  
  //private final Command m_autoCommand;
  SendableChooser<Command> qChooser = new SendableChooser<>();
  // Add commands to the autonomous command chooser

  // The robot's subsystems and commands are defined here...
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    this.leftJoystick = new Joystick(0);
    this.rightJoystick = new Joystick(1);
    this.controller2 = new XboxController(2);
    this.driveTrain = new AMDB5Subsystem();
    this.climb = new SkyHookSubsystem();
    this.intake = new ShakenNotStirredSubsystem();
    this.vision = new MoonRakerSubsystem();
    this.shooter = new GoldenPP7Subsystem();
    
    Command regular = new QAIRegular(driveTrain, intake, vision, shooter);
    Command shortauton = new QAIShort(driveTrain, intake, vision, shooter);
    Command threeball = new QAI3Ball(driveTrain, shooter, vision, intake);
    
    driveTrain.setDefaultCommand(new AMDB5Command(driveTrain,leftJoystick,rightJoystick));
    climb.setDefaultCommand(new SkyHookCommand(climb, rightJoystick, controller2));
    intake.setDefaultCommand(new ShakenNotStirredCommand(intake, leftJoystick, rightJoystick, controller2));
    shooter.setDefaultCommand(new GoldenPP7Command(shooter, leftJoystick, rightJoystick, controller2, vision));

    configureButtonBindings();

    qChooser.setDefaultOption("Regular Auton", regular);
    qChooser.addOption("Short Auton (for the wall)", shortauton);
    qChooser.addOption("3 Balls Auton", threeball);

  // Put the chooser on the dashboard
    SmartDashboard.putData(qChooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Button visionButton = new JoystickButton(controller1, XboxController.Button.kBack.value);
    // visionButton
    //   .whenPressed(new QSpikeFanOnCommand(shooter, vision));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return qChooser.getSelected();
  }
}
