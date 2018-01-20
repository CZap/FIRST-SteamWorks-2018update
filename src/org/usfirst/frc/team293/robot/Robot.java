/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team293.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team293.robot.commands.ExampleCommand;
import org.usfirst.frc.team293.robot.subsystems.CombClimber;
import org.usfirst.frc.team293.robot.subsystems.continuousFunctions;
import org.usfirst.frc.team293.robot.subsystems.DriveTrain;
import org.usfirst.frc.team293.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team293.robot.subsystems.Feeder;
import org.usfirst.frc.team293.robot.subsystems.GearPouch;
import org.usfirst.frc.team293.robot.subsystems.LEDs;
import org.usfirst.frc.team293.robot.subsystems.Shooter;

import autonomi.ForwardDrive;
import autonomi.GearLeftHopperRight_GyroEncoder;
import autonomi.GearRightHopperLeft_GyroEncoder;
import autonomi.GearStraight_GyroEncoder;
import autonomi.GearTurnLeftGoal_GyroEncoder;
import autonomi.GearTurnLeft_GyroEncoder;
import autonomi.GearTurnRightGoal_GyroEncoder;
import autonomi.GearTurnRight_GyroEncoder;
import autonomi.HopperLongLeft_GyroEncoder;
import autonomi.HopperLongRight_Encoder;
import autonomi.HopperShooterLeftHopper_GyroEncoder;
import autonomi.HopperShooterRightHopper_GyroEncoder;
import autonomi.HopperShortLeft_GyroEncoder;
import autonomi.HopperShortRight_Encoder;
import autonomi.Shoot_Left_Encoder;
import autonomi.Shoot_Right_Encoder;
import autonomi.Stand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	public static OI m_oi;
	public static DriveTrain driveTrain;
	public static CombClimber Climber;
	public static continuousFunctions continuousFunctions;
	public static GearPouch gearPouch;
	public static Feeder feeder;
	public static LEDs lEDs;
	public static Shooter shooter;	
	//any reason why it was typeless?
    
    public static DriverStation.Alliance color;
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		shooter=new Shooter();
    	gearPouch=new GearPouch();
    	feeder = new Feeder();
    	driveTrain = new DriveTrain();
    	Climber=new CombClimber();
    	lEDs=new LEDs();
    	continuousFunctions=new continuousFunctions();
    	
        m_chooser = new SendableChooser<Command>();
        m_chooser.addDefault("1 Stand Still", new Stand());
        m_chooser.addObject("1 Foward Drive", new ForwardDrive());
        
        m_chooser.addObject("2 Center Gear *Sensors", new GearStraight_GyroEncoder());
        m_chooser.addObject("2 Gear (turn left)  *Sensors", new GearTurnLeft_GyroEncoder());
        m_chooser.addObject("2 Gear (turn right) *Sensors", new GearTurnRight_GyroEncoder());
		
        m_chooser.addObject("3 Shoot Right *Sensors",new Shoot_Right_Encoder());
        m_chooser.addObject("3 Shoot Left *Sensors",new Shoot_Left_Encoder());
		
        m_chooser.addObject("4 Left Long Hopper *Sensors", new HopperLongLeft_GyroEncoder());
        m_chooser.addObject("4 Right Long Hopper *Sensors", new HopperLongRight_Encoder());
        m_chooser.addObject("4 Right Short Hopper *Sensors", new HopperShortRight_Encoder());
        m_chooser.addObject("4 Left Short Hopper *Sensors", new HopperShortLeft_GyroEncoder());
        ////////Untested Below//////////////////////////
        m_chooser.addObject("5 Gear (turn right), left goal *Sensors", new GearTurnRightGoal_GyroEncoder());
		m_chooser.addObject("5 Gear (turn left), right goal *Sensors", new GearTurnLeftGoal_GyroEncoder());
		
        m_chooser.addObject("6 Gear (turn left), Right Far Hopper *Sensors", new GearLeftHopperRight_GyroEncoder());
		m_chooser.addObject("6 Gear (turn right), Left Far Hopper *Sensors", new GearRightHopperLeft_GyroEncoder());
		
        m_chooser.addObject("7 Hopper left, Shoot *Sensors", new HopperShooterLeftHopper_GyroEncoder());
        m_chooser.addObject("7 Hopper right, Shoot *Sensors", new HopperShooterRightHopper_GyroEncoder());
		
        SmartDashboard.putData("Auto mode Chooser", m_chooser);   
        
		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		color = DriverStation.getInstance().getAlliance();
    	Robot.gearPouch.upFlap();
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
