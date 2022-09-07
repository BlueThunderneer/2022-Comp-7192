package frc.robot.commands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSS;
import frc.robot.subsystems.ArmSS;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ArmUpTake extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on time. This will drive out for a period of time, turn
   * around for time (equivalent to time to turn around) and drive forward again. This should mimic
   * driving out, turning around and driving back.
   *
   * 
   */
  public ArmUpTake(ArmSS m_ArmSS, IntakeSS m_intakess) {
       addCommands(
        new intakeouttime(.5, m_intakess), //Raise the Cargo arm to shoot need to add this subsystem to the contstructor)
        new armup(m_ArmSS) // set solenoids to forward     
        ); //end of addCommands
     
  }    
}
