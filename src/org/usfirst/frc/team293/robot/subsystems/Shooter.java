package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.RobotMap;
import org.usfirst.frc.team293.robot.commands.ShooterLowGoal;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {
	TalonSRX shooter;
	VictorSP shooterTrigger;
	public Shooter(){
		shooter =new TalonSRX(RobotMap.shooter);
		shooterTrigger= new VictorSP(RobotMap.shooterTrigger);
		
	//	shooter.changeControlMode(TalonControlMode.PercentVbus);
		shooter.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		//shooter.reverseOutput(false);
		//shooter.reverseSensor(false);
		//shooter.configEncoderCodesPerRev(256);
		//shooterwheel.getMotionProfileTopLevelBufferCount();
		//shooter.setPID(22,0.00001, 1); // Set the PID constants (p, i, d)
		//shooter.setF(.6);// what we think it should be
	}
	
    public void initDefaultCommand() {
    }
    
    public void ShootHigh(){
    	//shooter.enableControl(); // Enable PID control on the talon
    	shooter.set(ControlMode.PercentOutput, .85);
    	shooterTrigger.set(-1);
    }
    
    public void ShootLow(){
    	//shooter.enableControl(); // Enable PID control on the talon    	
    	shooter.set(ControlMode.PercentOutput, .85);
    	shooterTrigger.set(-1);
    }
    
    public void ShootLowReverse(){
    	//shooter.enableControl(); // Enable PID control on the talon
    	shooterTrigger.set(1);
    	shooter.set(ControlMode.PercentOutput, -.85);
    }
    
    
    public void Stop(){
    	shooterTrigger.set(0);
    	shooter.set(ControlMode.PercentOutput, 0.0);
    	//shooter.disableControl(); // Enable PID control on the talon
    }
    
}

