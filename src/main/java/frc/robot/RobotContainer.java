package frc.robot;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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
  // private final MusicSubsystem musicSubsystem1;
  // private final MusicSubsystem musicSubsystem2;
  // private final MusicSubsystem musicSubsystem3;
  // private final MusicSubsystem musicSubsystem4;
  // private final MusicSubsystem musicSubsystem5;
  // private final MusicSubsystem musicSubsystem6;

  private final DriveSubsystem driveTrain;
  private final ClimbSubsystem climb;
  private final IntakeSubsystem intake;
  private final ShooterSubsystem shooter;
  private final VisionSubsystem vision;
  
  //private final Command m_autoCommand;
  SendableChooser<Command> qChooser = new SendableChooser<>();
  // Add commands to the autonomous command chooser

  // The robot's subsystems and commands are defined here...
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    this.leftJoystick = new Joystick(0);
    this.rightJoystick = new Joystick(1);
    this.controller2 = new XboxController(2);

    // var instruments1 = new ArrayList<TalonFX>();
    // instruments1.add(new TalonFX(5));
    // var instruments2 = new ArrayList<TalonFX>();
    // instruments2.add(new TalonFX(4));
    // var instruments3 = new ArrayList<TalonFX>();
    // instruments3.add(new TalonFX(3));
    // var instruments4 = new ArrayList<TalonFX>();
    // instruments4.add(new TalonFX(2));
    // var instruments5 = new ArrayList<TalonFX>();
    // instruments5.add(new TalonFX(30));
    // var instruments6 = new ArrayList<TalonFX>();
    // instruments6.add(new TalonFX(40));

    // this.musicSubsystem1 = new MusicSubsystem(instruments1);
    // this.musicSubsystem1.load("songwii.chrp");
    // this.musicSubsystem2 = new MusicSubsystem(instruments2);
    // this.musicSubsystem2.load("songwii.chrp");
    // this.musicSubsystem3 = new MusicSubsystem(instruments3);
    // this.musicSubsystem3.load("songwii.chrp");
    // this.musicSubsystem4 = new MusicSubsystem(instruments4);
    // this.musicSubsystem4.load("songwii.chrp");
    // this.musicSubsystem5 = new MusicSubsystem(instruments5);
    // this.musicSubsystem5.load("songwii.chrp");
    // this.musicSubsystem6 = new MusicSubsystem(instruments5);
    // this.musicSubsystem6.load("songwii.chrp");

    // Button musicButton1 = new JoystickButton(controller2, XboxController.Button.kA.value);
    // musicButton1
    //     .whenPressed(() -> this.musicSubsystem1.play());
    // Button musicButton2 = new JoystickButton(controller2, XboxController.Button.kA.value);
    // musicButton2    
    //     .whenPressed(() -> this.musicSubsystem2.play());
    // Button musicButton3 = new JoystickButton(controller2, XboxController.Button.kA.value);
    // musicButton3  
    //     .whenPressed(() -> this.musicSubsystem3.play());
    // Button musicButton4 = new JoystickButton(controller2, XboxController.Button.kA.value);
    // musicButton4
    //     .whenPressed(() -> this.musicSubsystem4.play());
    // Button musicButton5 = new JoystickButton(controller2, XboxController.Button.kA.value);
    // musicButton5  
    //     .whenPressed(() -> this.musicSubsystem5.play());
    // Button musicButton6 = new JoystickButton(controller2, XboxController.Button.kA.value);
    // musicButton6  
    //     .whenPressed(() -> this.musicSubsystem6.play());


    this.driveTrain = new DriveSubsystem();
    this.climb = new ClimbSubsystem();
    this.intake = new IntakeSubsystem();
    this.vision = new VisionSubsystem();
    this.shooter = new ShooterSubsystem();
    
    Command regular = new QAIRegular(driveTrain, intake, vision, shooter);
    Command shortauton = new QAIShort(driveTrain, intake, vision, shooter);
    Command threeball = new QAI3Ball(driveTrain, shooter, vision, intake);
    Command tv = new Tv(driveTrain);
    
    driveTrain.setDefaultCommand(new DriveCommand(driveTrain,leftJoystick,rightJoystick, controller2));
    climb.setDefaultCommand(new ClimbCommand(climb, rightJoystick, controller2));
    intake.setDefaultCommand(new IntakeCommand(intake, leftJoystick, rightJoystick, controller2));
    shooter.setDefaultCommand(new ShooterCommand(shooter, leftJoystick, rightJoystick, controller2, vision));

    configureButtonBindings();

    qChooser.setDefaultOption("code for youtube", tv);
    qChooser.addOption("Regular Auton", regular);
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
