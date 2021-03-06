/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team293.robot;

import org.usfirst.frc.team293.robot.commands.ClimberOff;
import org.usfirst.frc.team293.robot.commands.ClimberSlow;
import org.usfirst.frc.team293.robot.commands.ClimberUp;
import org.usfirst.frc.team293.robot.commands.FeederFoward;
import org.usfirst.frc.team293.robot.commands.FeederReverse;
import org.usfirst.frc.team293.robot.commands.FeederStop;
import org.usfirst.frc.team293.robot.commands.GearFlapDown;
import org.usfirst.frc.team293.robot.commands.GearFlapUp;
import org.usfirst.frc.team293.robot.commands.ShooterHighGoal;
import org.usfirst.frc.team293.robot.commands.ShooterLowGoal;
import org.usfirst.frc.team293.robot.commands.ShooterLowGoalReverse;
import org.usfirst.frc.team293.robot.commands.ShooterStop;
import org.usfirst.frc.team293.robot.commands.TankDriveReverse;
import org.usfirst.frc.team293.robot.subsystems.LEDButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	 public static Joystick leftStick = new Joystick(0);
	 public static Joystick rightStick=new Joystick(1);
	 public static Joystick launchpad=new Joystick(2);
	// public static Joystick launchpad2=new Joystick(3);
	 
	 public static LEDButton LEDFlaps = new LEDButton(1);
	 public static LEDButton LEDGear = new LEDButton(2);
	

	public OI() {
		JoystickButton[] left= {null,new JoystickButton(leftStick,1), 
									   new JoystickButton(leftStick,2), 
									   new JoystickButton(leftStick,3), 
									   new JoystickButton(leftStick,4), 
									   new JoystickButton(leftStick,5), 
									   new JoystickButton(leftStick,6), 
									   new JoystickButton(leftStick,7), 
									   new JoystickButton(leftStick,8), 
									   new JoystickButton(leftStick,9), 
									   new JoystickButton(leftStick,10),};
		
		JoystickButton[] right= {null,new JoystickButton(rightStick,1), 
									   new JoystickButton(rightStick,2), 
									   new JoystickButton(rightStick,3), 
									   new JoystickButton(rightStick,4), 
									   new JoystickButton(rightStick,5), 
									   new JoystickButton(rightStick,6), 
									   new JoystickButton(rightStick,7), 
									   new JoystickButton(rightStick,8), 
									   new JoystickButton(rightStick,9), 
									   new JoystickButton(rightStick,10),};
		
		
		//JoystickButton padOne=new JoystickButton(launchpad,RobotMap.pad1[0]);		//These are numbered top down, left to right
		//JoystickButton padTwo=new JoystickButton(launchpad,RobotMap.pad2[0]);
		//JoystickButton padThree=new JoystickButton(launchpad,RobotMap.pad3[0]);
		//JoystickButton padFour=new JoystickButton(launchpad,RobotMap.pad4[0]);
		//JoystickButton padFive=new JoystickButton(launchpad,RobotMap.pad5[0]);
		//JoystickButton padSix=new JoystickButton(launchpad,RobotMap.pad6[0]);
		//JoystickButton padSeven=new JoystickButton(launchpad,RobotMap.pad7[0]);
		//JoystickButton padEight=new JoystickButton(launchpad,RobotMap.pad8[0]);
		//JoystickButton padNine=new JoystickButton(launchpad,RobotMap.pad9[0]);
		
		JoystickButton switch1up=new JoystickButton(launchpad, 2);
		JoystickButton switch1dn=new JoystickButton(launchpad, 1);
		JoystickButton switch2up=new JoystickButton(launchpad, 4);
		JoystickButton switch2dn=new JoystickButton(launchpad, 3);
		JoystickButton switch3up=new JoystickButton(launchpad, 6);
		JoystickButton switch3dn=new JoystickButton(launchpad, 5);
		JoystickButton switch4up=new JoystickButton(launchpad, 8);
		JoystickButton switch4dn=new JoystickButton(launchpad, 7);
		
		
		switch1up.whenPressed(new ClimberUp());
		switch1dn.whenPressed(new ClimberSlow());
		switch2up.whenPressed(new ShooterLowGoal());
		switch2dn.whenPressed(new ShooterLowGoalReverse());
		switch3up.whenPressed(new FeederFoward());
		switch3dn.whenPressed(new FeederReverse());
		switch4up.whenPressed(new GearFlapDown());
		switch4dn.whenPressed(new GearFlapDown());
		
		switch1up.whenReleased(new ClimberOff());
		switch1dn.whenReleased(new ClimberOff());
		switch2up.whenReleased(new ShooterStop());
		switch2dn.whenReleased(new ShooterStop());
		switch3up.whenReleased(new FeederStop());
		switch3dn.whenReleased(new FeederStop());
		
		switch4up.whenReleased(new GearFlapUp());
		switch4dn.whenReleased(new GearFlapUp());
		
	
		
		//padTwo.whenPressed(new ClimberUp());
		//padOne.whenPressed(new ClimberDown());
		//padTwo.whenReleased(new ClimberOff());
		//padOne.whenReleased(new ClimberOff());

		//padThree.whenPressed(new ShooterLowGoal());
		//padThree.whenReleased(new ShooterStop());

		//padSix.whenPressed(new GearFlapUp());
		//padEight.whenPressed(new GearFlapDown());
		
		left[1].toggleWhenPressed(new TankDriveReverse());
		right[1].toggleWhenPressed(new TankDriveReverse());
		
		left[2].whenPressed(new FeederFoward());
		right[2].whenPressed(new FeederStop());
		
		left[3].whenPressed(new ShooterHighGoal());
		right[3].whenPressed(new ShooterStop());
		
		left[4].whenPressed(new GearFlapUp());
		right[4].whenPressed(new GearFlapDown());
		
		left[8].toggleWhenPressed(new ClimberUp());
		left[9].toggleWhenPressed(new ClimberSlow());
		right[8].toggleWhenPressed(new ClimberUp());
		right[9].toggleWhenPressed(new ClimberSlow());
	
	}
}
