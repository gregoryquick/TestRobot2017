package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.Robot;
import org.usfirst.frc.team948.robot.utilities.MathUtil;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class simpleTurnToHeading extends Command {

	private final double finalHeading;
	private double currentHeading;
	
    public simpleTurnToHeading(double heading) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	finalHeading = heading;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.rawStop();
    	currentHeading = Robot.rm.navx.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentHeading = Robot.rm.navx.getAngle();
    	double delta = finalHeading - currentHeading;
    	Robot.drive.rawTankDrive(MathUtil.inverseClamp(-0.2, 0.2, MathUtil.clamp(-0.5, 0.5,  MathUtil.deadband(0,0.05,delta/36)))
    			,-MathUtil.inverseClamp(-0.2, 0.2, MathUtil.clamp(-0.5, 0.5, MathUtil.deadband(0,0.05,delta/36))));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return MathUtil.deadband(finalHeading, 7.0, currentHeading) == 0;
    	return false;
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
