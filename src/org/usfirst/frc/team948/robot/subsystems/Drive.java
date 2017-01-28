package org.usfirst.frc.team948.robot.subsystems;

import org.usfirst.frc.team948.robot.RobotMap;
import org.usfirst.frc.team948.robot.commands.Idle;
import org.usfirst.frc.team948.robot.commands.MatchDesiredHeading;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem implements PIDOutput {
	private final double Turn_P = RobotMap.preferences.getDouble("Turn_D", 0.06);
	private final double Turn_I = RobotMap.preferences.getDouble("Turn_I", 0.003);
	private final double Turn_D = RobotMap.preferences.getDouble("Turn_D", 0.3);
	
	private PIDController drivePID;

	private double pidOutput;
    // Initialize your subsystem here
    public Drive() {
    	super("Drive");
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MatchDesiredHeading());
    }
    
    public void rawTankDrive(double powerLeft, double powerRight){
    	//Change to invert correctly and have motors use correct power
    	RobotMap.testMotor0.set(powerLeft);
    	RobotMap.testMotor1.set(powerLeft);
    	RobotMap.testMotor2.set(-powerRight);
    	RobotMap.testMotor3.set(-powerRight);
    }
    
    public void rawStop(){
    	RobotMap.testMotor0.set(0);;
    	RobotMap.testMotor1.set(0);
    	RobotMap.testMotor2.set(0);
    	RobotMap.testMotor3.set(0);
    }
    
    public void initTurnToHeading(double heading, double tolerence){
    	drivePID = new PIDController(Turn_P, Turn_I, Turn_D, RobotMap.navx, this);
    	drivePID.setInputRange(-180.0,  180.0);
    	drivePID.setOutputRange(-1.0, 1.0);
    	drivePID.setAbsoluteTolerance(tolerence);
        drivePID.setContinuous(true);
        drivePID.setSetpoint(heading);
    }
    
    public void turnTurnToHeading(){
    	rawTankDrive(pidOutput,pidOutput);
    }
    
    public void updateTurnToHeading(double heading){
    	drivePID.setSetpoint(heading);
    }
    
	public void endTurnToHeading() {
		drivePID.reset();
		drivePID.free();
		pidOutput = 0;
		rawStop();
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		pidOutput = output;
	}
}
