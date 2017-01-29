package org.usfirst.frc.team948.robot.utilities;

public class MathUtil {
	
	public static double clamp(double min, double max, double input){
		return input > max ? max : input < min ? min : input;
	}
	
	public static double deadband(double center, double tolerence, double input){
		return Math.abs(center - input) < tolerence ? 0 : input;
	}

}
