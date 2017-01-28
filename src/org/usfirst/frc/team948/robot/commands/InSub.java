package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.OI;
import org.usfirst.frc.team948.robot.Robot;
import org.usfirst.frc.team948.robot.RobotMap;
import org.usfirst.frc.team948.robot.subsystems.Drive;

import com.kauailabs.navx.frc.AHRS;

public interface InSub {
	public OI IO = Robot.oi;
	public Drive drive = Robot.drive;
	public AHRS navx = RobotMap.navx;
}
