package org.usfirst.frc3617.WifiSense;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc3617.WifiSense.RobotMap;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	RobotDrive myRobot;
	int autoLoopCounter;
	
    
    //moved from RobotMap
    public static Joystick driveStick;
	public static Joystick gunnerStick;
	static int frontRightMotor = 2,
			frontLeftMotor = 3,
			rearLeftMotor = 1,
			rearRightMotor = 0,
			cowMotor = 4,
			towerRepell = 5, //temporary code for tower climb
			towerClimber = 6;// temporary code for tower climb
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    	Robot.driveStick = new Joystick(0);
    	Robot.gunnerStick = new Joystick(1);
    	myRobot = new RobotDrive(frontRightMotor,rearRightMotor,rearLeftMotor,frontLeftMotor);
    	
    }
    
    
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
		{
			myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
			autoLoopCounter++;
			} else {
			myRobot.drive(0.0, 0.0); 	// stop robot
		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        myRobot.arcadeDrive(driveStick);
        RobotMap.cow.set(gunnerStick.getY());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }

}
