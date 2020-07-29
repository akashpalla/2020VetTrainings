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

  private TalonSRX leftIntake, rightIntake, pivotMotor;
  private DigitalInput topSensor, bottomSensor;
  private JoystickButton intakeButton;
  private Joystick joy;
  

  public void robotInit() {
    leftIntake = new TalonSRX(0);
    rightIntake = new TalonSRX(1);

    pivotMotor = new TalonSRX(3);

    topSensor = new DigitalInput(9);
    bottomSensor = new DigitalInput(8);

    joy = new Joystick(1);
    intakeButton = new JoystickButton(joy, 1);


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

    if(intakeButton.get()){                                         // If the intake button is pressed the pivot will lower until the bottom Sensor is triggered. Once the sensor is triggered
      if(!bottomSensor.get()){                                      // the intake motors will run. 
        pivotMotor.set(ControlMode.PercentOutput, -0.3);            // When the button is released, the intake will stop and the pivot will move up until the top sensor is triggered
      }else{                                                                  
        pivotMotor.set(ControlMode.PercentOutput, 0);
        leftIntake.set(ControlMode.PercentOutput, .4);
        rightIntake.set(ControlMode.PercentOutput, .4);
      }
    }else{
      leftIntake.set(ControlMode.PercentOutput, 0);
      rightIntake.set(ControlMode.PercentOutput, 0);

      if(!topSensor.get()){
        pivotMotor.set(ControlMode.PercentOutput, .3);
      }else{
        pivotMotor.set(ControlMode.PercentOutput, 0);
      }

    }
   
  }


  public void testInit() {
   
    CommandScheduler.getInstance().cancelAll();
  }

  
  public void testPeriodic() {
  }
}
