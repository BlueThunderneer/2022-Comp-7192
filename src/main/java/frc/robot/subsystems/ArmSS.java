package frc.robot.subsystems;

import frc.robot.commands.armdown;
import frc.robot.commands.armup;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXSimCollection;
import com.ctre.phoenix.motorcontrol.GroupMotorControllers;


//Remove comment flags for all spark max items and comment talon lines to switch to the neo moving the arm
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class ArmSS extends SubsystemBase{
    private DoubleSolenoid DS1;
    private DoubleSolenoid DS2;
    Compressor air;

    public ArmSS() {
        DS1 = new DoubleSolenoid(6, PneumaticsModuleType.CTREPCM, 0, 1); //0 is forward and 1 is reverse 
        DS2 = new DoubleSolenoid(6, PneumaticsModuleType.CTREPCM, 2, 3); //2 is forward and 3 is reverse
        air = new Compressor(6, PneumaticsModuleType.CTREPCM);
        }

    public void armup(){
        DS1.set(kForward);
        DS2.set(kForward);
        }

    public void airOFF(){
        air.disable();
        }   

    public void airON(){
        air.enableDigital();
        }

    public void initialize(){
        //DO NOTHING SO WE DO NOT MOVE THE ARM UNEXPECTEDLY
        }

    public void armdown(){
        DS1.set(kReverse);
        DS2.set(kReverse); 
        }

    public void stop() {
        //DO NOTHING SO WE DO NOT MOVE THE ARM UNEXPECTEDLY
        } 
    
    }


