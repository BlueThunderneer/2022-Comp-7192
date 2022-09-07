package frc.robot.commands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSS;
import frc.robot.subsystems.ArmSS;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonTime extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on time. This will drive out for a period of time, turn
   * around for time (equivalent to time to turn around) and drive forward again. This should mimic
   * driving out, turning around and driving back.
   *
   * 
   */
  public AutonTime(ArmSS m_ArmSS, Drivetrain m_drivetrain, IntakeSS m_intakess) {
       addCommands(
       // new ArmupTime(3.0, m_ArmSS), //Raise the Cargo arm to shoot need to add this subsystem to the contstructor)
        new intakeouttime(0.5, m_intakess),
        new ArmupTime(1.0, m_ArmSS), // set solenoids to forward
        //new Time(1),     //One Second Delay
        new LaunchBallTime(1.0, m_intakess),  //Launch the Ball into Hub, run intake out for 1 second
        new ArmdownTime(1.0, m_ArmSS),
        //new ArmdownTime(1.0, m_ArmSS),
        new DriveTime(-0.6, 0.0, 1.5, m_drivetrain), //Drive using these params (speed,Rotation,Time,Subsystem used)
        new DriveTime( 0, -0.5, 2.0, m_drivetrain ), // we spin around
        new DriveTime( 0.55, 0.0, 2.0, m_drivetrain) // go forward after spin
        
        ); //end of addCommands
     
  }    
}
