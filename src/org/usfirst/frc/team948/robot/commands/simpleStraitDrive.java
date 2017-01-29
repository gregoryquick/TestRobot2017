package org.usfirst.frc.team948.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team948.robot.Robot;

/**
 *
 */
public class simpleStraitDrive extends Command {
	
	private boolean tool;
	private double power;
	private Timer timer = new Timer();

    public simpleStraitDrive(double power, boolean bool) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	this.power = power;
    	tool = bool;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.rawStop();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.rawTankDrive(power, power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(tool)
    		return false;
    	if(timer.get() > 1){
    		timer.stop();
    		return true;
    	}
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
