package frc.robot.commands;
import frc.robot.subsystems.IntakeSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MechOut extends CommandBase{

    private final IntakeSS m_intakeSS; 

        public MechOut(IntakeSS subsystem){

            m_intakeSS = subsystem;
            addRequirements(m_intakeSS);
        }


        @Override
        public void initialize(){
            m_intakeSS.MechOut();
        }

        @Override 
        public void end(boolean interupted){
            m_intakeSS.stop();
        }
}
