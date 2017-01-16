package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.utilities.MathUtil;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualDrive extends Command implements InSub {
	
	private static double tolerence = 0.2;

    public ManualDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.rawDrive(MathUtil.deadband(IO.leftJS.getY(), tolerence),MathUtil.deadband(IO.rightJS.getY(), tolerence));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
