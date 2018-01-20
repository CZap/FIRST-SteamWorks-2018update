package org.usfirst.frc.team293.robot.subsystems;

import org.usfirst.frc.team293.robot.OI;
import org.usfirst.frc.team293.robot.Robot;
import org.usfirst.frc.team293.robot.RobotMap;
import org.usfirst.frc.team293.robot.commands.runContinuousFunctions;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class continuousFunctions extends Subsystem {
	public boolean hasGear = false;
	public int isAligned = 0;
	
	public PowerDistributionPanel pdp;
	
	public continuousFunctions(){
		pdp= new PowerDistributionPanel(4);

	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new runContinuousFunctions());
	}
	
	public void sensorLog(){	
    	SmartDashboard.putNumber("Encoder Rate right", Robot.driveTrain.rightEncoder.getRate());
		SmartDashboard.putNumber("Encoder Rate left", Robot.driveTrain.leftEncoder.getRate());
		SmartDashboard.putBoolean("Gear Optical Limit", Robot.gearPouch.hasGear.get());
    	PigeonIMU.FusionStatus fusionStatus = new PigeonIMU.FusionStatus();

		SmartDashboard.putNumber("IMU", Robot.driveTrain.imu.getFusedHeading(fusionStatus));
	}
	
	public void buttonsLED(){
		if (Robot.gearPouch.hasGear.get()){
			OI.LEDGear.on();
		}
		else{
			OI.LEDGear.off();
		}
	}
	
	public void currentMonitor(){
		
		SmartDashboard.putNumber("Total Current", pdp.getTotalCurrent());
		SmartDashboard.putNumber("DriveTrain Current", pdp.getCurrent(RobotMap.pdpLeftDrive[0])+pdp.getCurrent(RobotMap.pdpLeftDrive[1])+pdp.getCurrent(RobotMap.pdpLeftDrive[2])+pdp.getCurrent(RobotMap.pdpRightDrive[0])+pdp.getCurrent(RobotMap.pdpRightDrive[1])+pdp.getCurrent(RobotMap.pdpRightDrive[2]));
		SmartDashboard.putNumber("Shooter Current", pdp.getCurrent(RobotMap.pdpShooter));
		SmartDashboard.putNumber("Climber Current", pdp.getCurrent(RobotMap.pdpClimber));
	}


}
