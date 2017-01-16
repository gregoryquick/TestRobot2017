package org.usfirst.frc.team948.robot.subsystems;

import org.usfirst.frc.team948.robot.RobotMap;
import org.usfirst.frc.team948.robot.commands.ManualDrive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Subsystem implements PIDOutput{
	private PIDController drivePID;
	private static int LINV = 1;
	private static int RINV = -LINV;
	private final static double turnP = 1;
	private final static double turnI = 1;
	private final static double turnD = 1;
	private final static double driveP = 1;
	private final static double driveI = 1;
	private final static double driveD = 1;
	
    // Initialize your subsystem here
    public Drive() {
    	super();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManualDrive());
    	
    }
    
    public void rawDrive(double leftPow, double rightPow){
		RobotMap.backLeftMotor.set(LINV*leftPow);
		RobotMap.backRightMotor.set(RINV*rightPow);
		RobotMap.frontLeftMotor.set(LINV*leftPow);
		RobotMap.frontRightMotor.set(RINV*rightPow);
		SmartDashboard.putNumber("left Power", leftPow);
		SmartDashboard.putNumber("right Power", rightPow);
    }
    
	public void rawStop() {
		RobotMap.backLeftMotor.disable();
		RobotMap.backRightMotor.disable();
		RobotMap.frontLeftMotor.disable();
		RobotMap.frontRightMotor.disable();
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}

}
