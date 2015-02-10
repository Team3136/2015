package org.usfirst.frc.team3136.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	Talon frontL = new Talon(0);
	Talon frontR = new Talon(1);
	Talon backL = new Talon(3);
	Talon backR = new Talon(2);

	Joystick joy1 = new Joystick(0);
	
	//test change
	
	CameraServer server;

    public Robot() {
        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
    }

	public void robotInit() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		// Claw, use Z axis scroll wheel for lift? Buttons 4 and 5 for
		// closing/opening

		
		// Driving
		if (joy1.getTrigger()) {
			frontL.set(joy1.getX());
			frontR.set(joy1.getX());
			backL.set(joy1.getX());
			backR.set(joy1.getX());
		} else {
			frontL.set(joy1.getY() * -1);
			frontR.set(joy1.getX() * -1);
			backL.set(joy1.getX());
			backR.set(joy1.getY());
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
