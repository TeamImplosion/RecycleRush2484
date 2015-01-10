package org.usfirst.frc.team2484.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically it 
 * contains the code necessary to operate a robot with tank drive.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
    RobotDrive myRobot;  // class that handles basic drive operations
    Joystick driveStick;  
    Joystick armStick;
    static final int frontRightMotor= 0;
    static final int frontLeftMotor	= 0;
    static final int backRightMotor	= 0;
    static final int backLeftMotor	= 0;
	//XBox Controller Axis 
    static final int LEFT_Y_AXIS 	= 2;
    static final int RIGHT_Y_AXIS 	= 5;
	
	//XBox Controller buttons
    static final int X_BUT = 3;
    static final int Y_BUT = 4;

    public Robot() {
        myRobot = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
        myRobot.setExpiration(0.1);
        driveStick = new Joystick(0);
        armStick = new Joystick(1);
    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
        myRobot.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
        	myRobot.tankDrive(driveStick, LEFT_Y_AXIS, driveStick, RIGHT_Y_AXIS);
            Timer.delay(0.005);		// wait for a motor update time
        }
    }
}
