package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class simpleDriveStraitDistance extends Command {
	private final double initialDistplacementX;
	private final double initialDistplacementY;
	private final double initialHeading;
	private final double distance;
    public simpleDriveStraitDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	initialDistplacementX = (double) Robot.rm.navx.getDisplacementX();
    	initialDistplacementY = (double) Robot.rm.navx.getDisplacementY();
    	initialHeading = (double) Robot.rm.navx.getAngle();
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
