package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;
import org.usfirst.frc.team293.robot.subsystems.LEDs;
import org.usfirst.frc.team293.robot.subsystems.continuousFunctions;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class runContinuousFunctions extends Command {

	public runContinuousFunctions(){
		requires(Robot.continuousFunctions);
	}
	   protected void initialize() {
	    	Robot.continuousFunctions.pdp.clearStickyFaults();
	    }
	protected void execute(){
		Robot.continuousFunctions.currentMonitor();
		Robot.continuousFunctions.sensorLog();
		Robot.continuousFunctions.buttonsLED();
	}
	
	public void sendLEDCode(){
//		if(Robot.ContinuousFunctions.hasGear){
	//		Robot.LEDs.sendData(Robot.LEDs.yellowSolid);
	//	}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
