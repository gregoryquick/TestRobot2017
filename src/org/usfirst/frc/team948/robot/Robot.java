
package org.usfirst.frc.team948.robot;

import org.usfirst.frc.team948.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DS2017 oi;
	public static Drive drive = new Drive();
	Command autonomousCommand;
	SendableChooser chooser;

	public void robotInit() {
		oi = new DS2017();
		chooser = new SendableChooser();
		SmartDashboard.putData("Auto mode", chooser);
		DS2017.buttonInit();
	}

	public void disabledInit() {

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
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
	public void periodicAll()
	{
		SmartDashboard.putData("reset encoders", new Command(){

				@Override
				protected void initialize() {
					
				}
	
				@Override
				protected void execute() {
					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();
				}
	
				@Override
				protected boolean isFinished() {
					return true;
				}
	
				@Override
				protected void end() {
					
				}
	
				@Override
				protected void interrupted() {
					end();
				}
			});
		SmartDashboard.putNumber("Left Drive Encoder", RobotMap.leftEncoder.get());
		SmartDashboard.putNumber("Right Drive Encoder", RobotMap.rightEncoder.get());
		SmartDashboard.putNumber("Left Joystick Y", DS2017.leftJS.getY());
		SmartDashboard.putNumber("Right Joystick Y", DS2017.rightJS.getY());
	}

}
