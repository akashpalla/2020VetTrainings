package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {

  
  public void robotInit() {
  
  }

  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  
  public void disabledInit() {
  }


  public void disabledPeriodic() {
  }

  
  public void autonomousInit() {
   
  }

 
  public void autonomousPeriodic() {
  }

  
  public void teleopInit() {
    
  }

  
  public void teleopPeriodic() {
  }


  public void testInit() {
   
    CommandScheduler.getInstance().cancelAll();
  }

  
  public void testPeriodic() {
  }
}
