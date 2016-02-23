/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc3617.WifiSense.commands;

import org.usfirst.frc3617.WifiSense.Robot;
import org.usfirst.frc3617.WifiSense.RobotMap;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Thayer
 */
public class Driver extends Command{
	JoystickButton gStickUp;
	JoystickButton gRobotUp;
	
	
	public Driver(){

		// Use requires() here to declare subsystem dependencies
	}
	
	// Called just before this Command runs the first time
	protected void initialize(){
      gStickUp = new JoystickButton(RobotMap.gunnerStick, RobotMap.upStickButton);
	  gRobotUp = new JoystickButton(RobotMap.gunnerStick, RobotMap.upRobotButton);
		   	
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute(){
	    Robot.myRobot.arcadeDrive(-RobotMap.driveStick.getY(), -RobotMap.driveStick.getX());
        RobotMap.cow.set(RobotMap.gunnerStick.getY() / 3);
     
    	   if(gStickUp.get() == true){
    		   RobotMap.upMotor.set(0.6);
    		   RobotMap.pullUp.set(-1);
    	   }
    	   else if(gRobotUp.get() == true){
    		   RobotMap.upMotor.set(-0.8);
    		   RobotMap.pullUp.set(0.3);
    	   }
    	   else{
    		   RobotMap.upMotor.set(0);
    		   RobotMap.pullUp.set(0);
    		   }
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished(){
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end(){
	Robot.myRobot.arcadeDrive(0,0);
     RobotMap.cow.set(0);
        RobotMap.upMotor.set(0);
	    RobotMap.pullUp.set(0);
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted(){
		//end();
	}

	}
