// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
// Hell, Its me 

package frc.robot;

import frc.robot.commands.DriveCommand;
import frc.robot.commands.ArmDownTake;
import frc.robot.commands.ArmUpTake;
import frc.robot.commands.AutonTime;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.GrabBall;
import frc.robot.commands.LaunchBall;
import frc.robot.commands.MechOut;
import frc.robot.commands.MechIn;
import frc.robot.commands.armdown;
import frc.robot.commands.armup;
import frc.robot.commands.intakeout;
import frc.robot.commands.intakein;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.airOFF;
import frc.robot.commands.airON;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSS;
import frc.robot.subsystems.ArmSS;
import frc.robot.subsystems.ClimbSS;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Drivetrain m_drivetrain = new Drivetrain();
    public final IntakeSS m_intakess = new IntakeSS();
    public final ArmSS m_armss = new ArmSS();
    public final ClimbSS m_ClimbSS = new ClimbSS();

// Joysticks
private final Joystick m_controller = new Joystick(0);
private final Joystick m_opJoy1 = new Joystick(1);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  // A complex auto routine that drives forward, drops a hatch, and then drives backward.
  private final Command m_LandDAuto = new AutonTime(m_armss, m_drivetrain, m_intakess);
  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {

    // Smartdashboard Subsystems

    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand(m_drivetrain));
    SmartDashboard.putData("DriveCommand", new DriveCommand( m_drivetrain, null, null));
    SmartDashboard.putNumber("SpeedMultiplier", 1.0);

    // Configure the button bindings
    configureButtonBindings();

    
    // Configure default commands
    m_chooser.setDefaultOption("Launch n Drive", m_LandDAuto);
    m_chooser.addOption("Autonomous Command", new AutonomousCommand(m_drivetrain));
    // Configure autonomous sendable chooser
    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.
    m_drivetrain.setDefaultCommand(getArcadeDriveCommand());
    //Run intake IN when the opJoy1 trigger is held
    new JoystickButton(m_opJoy1, 2)
      .whenHeld(new GrabBall(m_intakess));
    //Run intake OUT when the opJoy1 thumb button is held
    new JoystickButton(m_opJoy1, 1)
      .whenHeld(new LaunchBall(m_intakess));
    //Raise the arm when opJoy1 left button (3) on top of joystick is pressed
      new JoystickButton(m_opJoy1, 3)
      .whenPressed(new ArmUpTake(m_armss, m_intakess));
    //Raise the arm when opJoy1 right button (4) on top of joystick is pressed
      new JoystickButton(m_opJoy1, 4)
      .whenPressed(new ArmDownTake(m_armss, m_intakess));
    //Raise the climber when driver controller A button is held
      new JoystickButton(m_controller, 1)
      .whenHeld(new ClimbUp(m_ClimbSS));
    //Raise the climber when driver controller B button is held
      new JoystickButton(m_controller, 2)
      .whenHeld(new ClimbDown(m_ClimbSS));
    //Disable Compressor when driver controller Y button is Pressed
      new JoystickButton(m_controller, 4)
      .whenPressed(new airOFF(m_armss));
      //grab when button 5 is pressed
      new JoystickButton(m_opJoy1, 9)
      .whenPressed(new intakeout(m_intakess));
      //letgo when button 6 is pressed
      new JoystickButton(m_opJoy1, 11)
      .whenPressed(new intakein(m_intakess));
      new JoystickButton(m_opJoy1, 5)
      .whenPressed(new MechOut(m_intakess));
    //Enable Compressor when driver controller X button is Pressed
      new JoystickButton(m_controller, 3)
      .whenPressed(new airON(m_armss));
 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  
  /**
   * Use this to pass the teleop command to the main {@link Robot} class.
   *
   * @return the command to run in teleop
   */
  public Command getArcadeDriveCommand() {
    return new DriveCommand(
        m_drivetrain, () -> -m_controller.getRawAxis(1), () -> m_controller.getRawAxis(4));
  }

}

