// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import com.ctre.phoenix.sensors.PigeonIMU;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.sensors.WPI_PigeonIMU;


/**
 *
 */
public class Drivetrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private Spark spark0;
private Spark spark1;
private MotorControllerGroup rightDrive;
private Spark spark2;
private Spark spark3;
private MotorControllerGroup leftDrive;
private DifferentialDrive drive;

private WPI_PigeonIMU Pigeon = new WPI_PigeonIMU(7);
 //double PG = 1; // The gain for a simple P loop - gain is a multiplier
 //getAngle(Pigeon);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
spark0 = new Spark(0);  //speed controller 0
 addChild("Spark0",spark0);
 spark0.setInverted(false);

spark1 = new Spark(1);  //speed controlled 1
 addChild("Spark1",spark1);
 spark1.setInverted(true);

    rightDrive = new MotorControllerGroup(spark0, spark1  );
    addChild("RightDrive",rightDrive);
 

spark2 = new Spark(2);      //speed controller 2
 addChild("Spark2",spark2);
 spark2.setInverted(false);

spark3 = new Spark(3);      //speed controller 3
 addChild("Spark3",spark3);
 spark3.setInverted(true);

leftDrive = new MotorControllerGroup(spark2, spark3  ); //pairs them together in sync
 addChild("LeftDrive",leftDrive);
//jijijii
//lmoomlmoommoooocow
drive = new DifferentialDrive(rightDrive, leftDrive);
 addChild("Drive",drive);
 drive.setSafetyEnabled(true);
drive.setExpiration(0.1);
drive.setMaxOutput(1.0);
    }



        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
        drive.arcadeDrive(xaxisSpeed, zaxisRotate, true);
      }

      

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public void zeroHeading(){
        Pigeon.reset();
    }
    
    public double getHeading(){
        return Math.IEEEremainder(Pigeon.getAngle(), 360) * (1.0);
    }
    
    public double getTurnRate(){
        return Pigeon.getRate() * (1.0);
    

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

