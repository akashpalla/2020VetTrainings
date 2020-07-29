package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class Robot extends TimedRobot {

  private TalonSRX leftIntake, rightIntake;
  private JoystickButton intakeButton;
  private Joystick joy;
  private boolean lastButtonVal;
  private double startTime;

  public void robotInit() {
    leftIntake = new TalonSRX(0);
    rightIntake = new TalonSRX(1);

    joy = new Joystick(1);
    intakeButton = new JoystickButton(joy, 1);

    lastButtonVal = false;
    startTime = 0;

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

    if(intakeButton.get() && !lastButtonVal){       // Checks that the button has just been pressed, and starts the intake
      startTime = Timer.getFPGATimestamp();
      leftIntake.set(ControlMode.PercentOutput, .2);
      rightIntake.set(ControlMode.PercentOutput, .2);
      
    }

    if(Timer.getFPGATimestamp() - startTime > 3){       // If it has been 3 seconds since the button has been pressed, stop the Intake
      leftIntake.set(ControlMode.PercentOutput, 0);
      rightIntake.set(ControlMode.PercentOutput, 0);
    }

    lastButtonVal = intakeButton.get();
  }


  public void testInit() {
   
    CommandScheduler.getInstance().cancelAll();
  }

  
  public void testPeriodic() {
  }
}
