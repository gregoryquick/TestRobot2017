package org.usfirst.frc.team948.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Spark testMotor0 = new Spark(0);
	public static Spark testMotor1 = new Spark(1);
	public static Spark testMotor2 = new Spark(2);
	public static Spark testMotor3 = new Spark(3);
	public static Encoder testEncoder = new Encoder(0, 1,false, Encoder.EncodingType.k4X);
	public static AHRS navx;
	public Preferences preferences;
}
