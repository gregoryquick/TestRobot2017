package org.usfirst.frc.team948.robot.utilities;

public class MathUtil {
	
	public static double clamp(double min, double max, double input){
		return input > max ? max : input < min ? min : input;
	}
	
	public static double inverseClamp(double min, double max, double input){
		double center = (min+max)/2;
		return (input > min && input < center) ? min : (input < max && input > center) ? max : input == center ? center : input;
	}
	
	public static double deadband(double center, double tolerence, double input){
		return Math.abs(center - input) < tolerence ? 0 : input;
	}

}
