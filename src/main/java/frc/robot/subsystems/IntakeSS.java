package frc.robot.subsystems;

//Import all the Lib things
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

// An intake mechanism with two motors driving 4" compliant wheels on opposite sides of a ball
public class IntakeSS extends SubsystemBase {
    private Spark spark4;
    private Spark spark5;
    private Spark spark6;
    private MotorControllerGroup intakemotors;
    private DoubleSolenoid DS3;
    private DoubleSolenoid DS4;

public IntakeSS() {
    spark4 = new Spark(4);   //define motor controller 4
    addChild("Spark4",spark4);
    spark4.setInverted(false);

    spark5 = new Spark(5);  //define motor controller 5
    addChild("Spark5",spark5);
    //Inverted so it runs in opposite direction as Spark4 when added to the group in the next few lines
    spark5.setInverted(true);
    
    spark6 = new Spark(6);  //define motor controller 6 (Mech wheels because yes)
    addChild("Spark6",spark6);

    //Put the motor controllers in a group 
    intakemotors = new MotorControllerGroup(spark4, spark5);
    addChild("IntakeMotors",intakemotors);

    DS3 = new DoubleSolenoid(6, PneumaticsModuleType.CTREPCM, 4, 5); //4 is forward and 5 is reverse 
    DS4 = new DoubleSolenoid(6, PneumaticsModuleType.CTREPCM, 6, 7); //6 is forward and 7 is reverse
    }

    

    /** Grabs the ball */
public void grabBall() {
    intakemotors.set(0.5);
    spark6.set(0.5);
   }

  /** Launches the ball. */
public void launchBall() {
    intakemotors.set(-1.0);
  }

  public void MechIn() {
    spark6.set(0.5);
   }

  /** Launches the ball. */
public void MechOut() {
    spark6.set(-1.0);
  }

public void intakeout(){
  DS3.set(kForward);
  DS4.set(kForward);
}

public void intakein(){
    DS3.set(kReverse);
    DS4.set(kReverse);
}
   
  // Stops running intake. This is called at the end of Grab and Launch Ball Commands.
  // Stops the intake motors when the button is released.
public void stop() {
    intakemotors.set(0.0);
    spark6.set(0.0);
  }        
}
