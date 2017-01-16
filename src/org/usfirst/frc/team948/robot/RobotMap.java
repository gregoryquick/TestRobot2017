package org.usfirst.frc.team948.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Victor backLeftMotor = new Victor(3);
	public static Victor frontLeftMotor = new Victor(2);
	public static Victor backRightMotor = new Victor(1);
	public static Victor frontRightMotor = new Victor(0);
	public static Encoder rightEncoder = new Encoder(2,3);
	public static Encoder leftEncoder = new Encoder(0,1);
}
