
package org.usfirst.frc.team948.robot;


import org.usfirst.frc.team948.robot.subsystems.Drive;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drive drive = new Drive();
	Command autonomousCommand;
	SendableChooser chooser;
	UsbCamera camera;

	public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser();
		RobotMap.testEncoder.setDistancePerPulse(1);
		SmartDashboard.putData("Auto mode", chooser);
		SmartDashboard.putNumber("DesiredHeading", RobotMap.navx.getAngle());
//		camera = CameraServer.getInstance().startAutomaticCapture();
		LiveWindow.addActuator("Drive", "Spark0", RobotMap.testMotor0);
		LiveWindow.addActuator("Drive", "Spark1", RobotMap.testMotor1);
		LiveWindow.addActuator("Drive", "Spark2", RobotMap.testMotor2);
		LiveWindow.addActuator("Drive", "Spark3" , RobotMap.testMotor3);
		LiveWindow.addSensor("Drive", "Encoder", RobotMap.testEncoder);
	}

	public void disabledInit() {
		RobotMap.testEncoder.reset();
		RobotMap.testEncoder.reset();
	}

	public void disabledPeriodic() {
		periodicAll();
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		periodicAll();
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	
	public void teleopPeriodic() {
		periodicAll();
//		RobotMap.testMotor.set(1);
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
//		RobotMap.testMotor.set(1);
		LiveWindow.run();
	}
	public void periodicAll()
	{
		SmartDashboard.putNumber("Heading", RobotMap.navx.getAngle());
//		SmartDashboard.putData("reset encoders", new Command(){
//
//				@Override
//				protected void initialize() {
//					
//				}
//	
//				@Override
//				protected void execute() {
//
//				}
//	
//				@Override
//				protected boolean isFinished() {
//					return true;
//				}
//	
//				@Override
//				protected void end() {
//					
//				}
//	
//				@Override
//				protected void interrupted() {
//					end();
//				}
//			});
	}

}
