package frc.robot.commands;
import frc.robot.subsystems.IntakeSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class intakeouttime extends CommandBase{

    private final IntakeSS m_intakeSS; 

    private final double m_duration;

    private long m_startTime;

    public intakeouttime(double time, IntakeSS subsytem){
        m_intakeSS = subsytem;
        m_duration = time * 1000;
        addRequirements(m_intakeSS);
    }

    @Override
    public void initialize(){
        m_startTime = System.currentTimeMillis();
        m_intakeSS.intakeout();
    }
    
    @Override
    public void end(boolean interrupted){
        m_intakeSS.stop();
    }
    @Override
    public boolean isFinished(){
        return(System.currentTimeMillis() - m_startTime) >= m_duration;
    }
}