package org.usfirst.frc3617.WifiSense;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc3617.WifiSense.commands.Driver;
import org.usfirst.frc3617.WifiSense.RobotMap;
import org.usfirst.frc3617.WifiSense.commands.AutonomousCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static RobotDrive myRobot;
    public static int autoMode = 1;
    //moved from RobotMap
	
	AutonomousCommand AutonomousCommand = new AutonomousCommand();
	Driver Driver = new Driver();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
   RobotMap.driveStick = new Joystick(0);
    	RobotMap.gunnerStick = new Joystick(1);
    	myRobot = new RobotDrive(RobotMap.frontLeftMotor,RobotMap.rearLeftMotor,RobotMap.frontRightMotor,RobotMap.rearRightMotor);
    }
    
    
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
        myRobot.setSafetyEnabled(false);
    	AutonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
		Scheduler.getInstance().run();
    }
    /*
	*/
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	myRobot.setSafetyEnabled(true);
    	Driver.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }

}
