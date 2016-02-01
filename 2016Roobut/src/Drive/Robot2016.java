	package Drive;
	import edu.wpi.first.wpilibj.IterativeRobot;
	import edu.wpi.first.wpilibj.Joystick;
	import edu.wpi.first.wpilibj.RobotDrive;
	import edu.wpi.first.wpilibj.livewindow.LiveWindow;
	//Where is edu? Not recognized. Needs changing?
	
	/**
	 * The VM is configured to automatically run this class, and to call the
	 * functions corresponding to each mode, as described in the IterativeRobot
	 * documentation. If you change the name of this class or the package after
	 * creating this project, you must also update the manifest file in the resource
	 * directory.
	 */
	public class Robot2016 extends IterativeRobot {
		RobotDrive myRobot;
		Joystick stick;
		int autoLoopCounter;	
		//Are there classes for these I'm just not finding?
		
	    /**
	     * This function is run when the robot is first started up and should be
	     * used for any initialization code.
	     */
	    public void robotInit() {
	    	myRobot = new RobotDrive(0,1);
	    	stick = new Joystick(0);
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
	    //This class looks good - are we running this or the code Noah got off the internet somewhere?
	    
	    /**
	     * This function is called once each time the robot enters tele-operated mode
	     */
	    public void teleopInit(){
	    }

	    /**
	     * This function is called periodically during operator control
	     */
	    public void teleopPeriodic() {
	        myRobot.arcadeDrive(stick);
	    }
	    
	    /**
	     * This function is called periodically during test mode
	     */
	    public void testPeriodic() {
	    	LiveWindow.run();
	    }
	    
	}
	/**
	 * Overall this looks good, I need to look for the instances and objects in here referencing things I can't see.
	 * (Work on with Will)
	 */


}
