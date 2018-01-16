package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CombClimber extends Subsystem {
	
	public TalonSRX climber, climbertwo;
	
	public CombClimber(){
		climber =new TalonSRX(RobotMap.climber);	
		//climbertwo=new TalonSRX(RobotMap.climbertwo);
		climber.changeControlMode(TalonControlMode.PercentVbus);
		climber.enableBrakeMode(true);
		//climbertwo.enableBrakeMode(true);
		
		climber.EnableCurrentLimit(true);
		//climbertwo.EnableCurrentLimit(true);
		//climbertwo.setCurrentLimit(38);
	}
	
    public void initDefaultCommand() {
    }
    
    public void start(){
    	climber.set(1);  
    	//climbertwo.set(1);
    }
    
    public void startSlow(){
    	climber.set(.5);
    }

    public void reverse(){	//may need to be removed
    //	climber.set(.5);
    	//climbertwo.set(-.4);
    }
    
    public void stop(){
    	climber.set(0); 	
    	//climbertwo.set(0);
    }
}

