package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.DS2017;
import org.usfirst.frc.team948.robot.Robot;
import org.usfirst.frc.team948.robot.subsystems.Drive;

public interface InSub {
	public DS2017 IO = Robot.oi;
	public Drive drive = Robot.drive;
}
