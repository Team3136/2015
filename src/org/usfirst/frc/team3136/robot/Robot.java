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

		
		//Some test code for creating a gradual acceleration for the elevator's
		//z motion. This code attempts to implement an increase in speed according
		//to the exponential function f(x)=2^x, x <= 0
		
		//NOTE: STILL WORKING ON THIS, NOT ALL METHOD CALLS ARE REAL
		/*
		 * int final MAX_ELEVATOR_SPEED = 100; //100%
		 * int final INCREMENT_SPEED = 35;
		 * 
		 * if(elevator_button.isPressed())
		 * 		if(elevMotor.currentSpeed() == 0)
		 * 			for(int i = 2; i <= MAX_ELEVATOR_SPEED; i^2){
		 * 				elevMotor.set(i);
		 * 				Thread.sleep(INCREMENT_SPEED); //adjust constant adjust acceleration
		 * 			}
		 * 
		 * 			while(elevator_button.isPressed()) elevMotor.set(i);
		 * 	
		 * 	else if (!(elevator_button.isPressed()) && elevMotor.currentSpeed() > 0) {
		 * 		for(int i = elevMotor.currentSpeed(); i >= 0; Math.sqrt(i))
		 * 			elevMotor.set(i);
		 * 			Thread.sleep(INCREMENT_SPEED);
		 *  }
		 *
		 */
		
		
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
