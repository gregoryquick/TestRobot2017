package org.usfirst.frc.team948.robot.commands;

import org.usfirst.frc.team948.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToHeading extends Command implements InSub{
	double heading;
	private double Turn_T = RobotMap.preferences.getDouble("Turn_T", 1.0);
    public TurnToHeading(double heading) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.heading = heading;
    }
    
    public TurnToHeading(double heading, double tolerence) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.heading = heading;
    	Turn_T = tolerence;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.initTurnToHeading(heading, Turn_T);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.turnTurnToHeading();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(navx.getAngle() - heading) <= Turn_T;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.endTurnToHeading();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
