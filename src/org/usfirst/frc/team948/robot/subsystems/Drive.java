package org.usfirst.frc.team948.robot.subsystems;

import org.usfirst.frc.team948.robot.Robot;
import org.usfirst.frc.team948.robot.RobotMap;
import org.usfirst.frc.team948.robot.commands.simpleStraitDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	private final RobotMap rm;
	public Drive(){
		this.rm = Robot.rm;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new simpleStraitDrive(0,true));
    }
    
    public void rawTankDrive(double leftPower, double rightPower){
    	rm.frontLeftMotor.set(leftPower);
    	rm.backLeftMotor.set(leftPower);
    	rm.frontRightMotor.set(rightPower);
    	rm.backRightMotor.set(rightPower);
    }
    
    public void rawStop(){
    	rm.frontLeftMotor.set(0);
    	rm.backLeftMotor.set(0);
    	rm.frontRightMotor.set(0);
    	rm.backRightMotor.set(0);
    }
}

