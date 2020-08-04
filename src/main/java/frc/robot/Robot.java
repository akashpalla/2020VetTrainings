package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalGlitchFilter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class Robot extends TimedRobot {

  private TalonSRX leftFront, rightFront, leftBack, rightBack;
  private Joystick joy;
  

  public void robotInit() {
  
    leftFront = new TalonSRX(1);
    leftBack = new TalonSRX(2);
    rightFront = new TalonSRX(3);
    rightBack = new TalonSRX(4);

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
    
    joy = new Joystick(0);


  }

  public double getX(){
    return joy.getRawAxis(5);
  }

  public double getY(){
    return joy.getRawAxis(6);
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

    double leftSpeed = 0.7 * getY() + 0.3 * getX();
    double rightSpeed = 0.7 * getY() - 0.3 * getX();
   
    leftFront.set(ControlMode.PercentOutput, leftSpeed);
    rightFront.set(ControlMode.PercentOutput,rightSpeed);
    
  }


  public void testInit() {
   
    CommandScheduler.getInstance().cancelAll();
  }

  
  public void testPeriodic() {
  }

}
