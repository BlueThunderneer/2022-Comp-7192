package frc.robot.commands;
import frc.robot.subsystems.IntakeSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MechIn extends CommandBase{

    private final IntakeSS m_intakeSS; 

        public MechIn(IntakeSS subsystem){

            m_intakeSS = subsystem;
            addRequirements(m_intakeSS);
        }


        @Override
        public void initialize(){
            m_intakeSS.MechIn();
        }

        @Override 
        public void end(boolean interupted){
            m_intakeSS.stop();
        }
}
