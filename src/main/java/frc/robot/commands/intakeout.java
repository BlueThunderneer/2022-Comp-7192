package frc.robot.commands;
import frc.robot.subsystems.IntakeSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class intakeout extends CommandBase{

    private final IntakeSS m_intakeSS; 

    public intakeout(IntakeSS subsytem){
        m_intakeSS = subsytem;
        addRequirements(m_intakeSS);
    }

    @Override
    public void initialize(){
        m_intakeSS.intakeout();
    }
    
    @Override
    public void end(boolean interrupted){
        
    }
}