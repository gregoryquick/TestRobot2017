package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.Robot;
import org.usfirst.frc.team948.robot.utilities.MathUtil;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class simpleTurnDegrees extends Command {

	private final double startHeading;
	private final double finalHeading;
	private double currentHeading;
	
    public simpleTurnDegrees(double deltaheading) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	startHeading = Robot.rm.navx.getAngle();
    	finalHeading = startHeading + deltaheading;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.rawStop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentHeading = Robot.rm.navx.getAngle();
    	double delta = finalHeading - currentHeading;
    	Robot.drive.rawTankDrive(MathUtil.clamp(-0.3, 0.3, delta/36),-MathUtil.clamp(-0.3, 0.3, delta/36));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return MathUtil.deadband(finalHeading, 7.0, currentHeading) == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.rawStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
