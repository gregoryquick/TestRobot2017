package org.usfirst.frc.team948.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public final Preferences prefs;
	public final Spark frontRightMotor;
	public final Spark frontLeftMotor;
	public final Spark backRightMotor;
	public final Spark backLeftMotor;
	public final AHRS navx;
	
	public RobotMap(){
		//Inititilize preferences
		prefs = Preferences.getInstance();
		
		//Map drive motors to ports
		frontRightMotor = new Spark(prefs.getInt("frontDriveRightMotorPort", 2));
		backRightMotor = new Spark(prefs.getInt("backDriveRightMotorPort", 0));
		frontLeftMotor = new Spark(prefs.getInt("frontDriveLeftMotorPort", 1));
		backLeftMotor = new Spark(prefs.getInt("backDriveLeftMotorPort", 3));
		
		//Set motor inversion
		frontRightMotor.setInverted(prefs.getBoolean("rightDriveMotorsInverted", true));
		backRightMotor.setInverted(prefs.getBoolean("rightDriveMotorsInverted", true));
		frontLeftMotor.setInverted(prefs.getBoolean("leftDriveMotorsInverted", false));
		backLeftMotor.setInverted(prefs.getBoolean("leftDriveMotorsInverted", false));
		
		//Add motors to liveWindow
		LiveWindow.addActuator("Drive", "frontRightMotor", frontRightMotor);
		LiveWindow.addActuator("Drive", "backRightMotor", backRightMotor);
		LiveWindow.addActuator("Drive", "frontLeftMotor", frontLeftMotor);
		LiveWindow.addActuator("Drive", "backLeftMotor", backLeftMotor);
		
		//Initiates navx
		navx = new AHRS(SPI.Port.kMXP);
		navx.reset();
	}
}
