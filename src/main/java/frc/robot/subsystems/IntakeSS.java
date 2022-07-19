package frc.robot.subsystems;

//Import all the Lib things
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// An intake mechanism with two motors driving 4" compliant wheels on opposite sides of a ball
public class IntakeSS extends SubsystemBase {
    private Spark spark4;
    private Spark spark5;
    private Spark spark6;
    private MotorControllerGroup intakemotors;

public IntakeSS() {
    spark4 = new Spark(4);   //define motor controller 4
    addChild("Spark4",spark4);
    spark4.setInverted(false);

    spark5 = new Spark(5);  //define motor controller 5
    addChild("Spark5",spark5);
    //Inverted so it runs in opposite direction as Spark4 when added to the group in the next few lines
    spark5.setInverted(true);
    
    spark6 = new Spark(6);  //define motor controller 6
    addChild("Spark6",spark6);

    //Put the motor controllers in a group 
    intakemotors = new MotorControllerGroup(spark4, spark5, spark6);
    addChild("IntakeMotors",intakemotors);
    }

    /** Grabs the ball */
public void grabBall() {
    intakemotors.set(0.5);
   }

  /** Launches the ball. */
public void launchBall() {
    intakemotors.set(-1.0);
  }
   
  // Stops running intake. This is called at the end of Grab and Launch Ball Commands.
  // Stops the intake motors when the button is released.
public void stop() {
    intakemotors.set(0.0);
  }        
}
