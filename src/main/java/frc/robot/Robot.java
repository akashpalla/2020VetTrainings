/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;


  private TalonSRX leftIntake, rightIntake;
  private Joystick joystick;
  private JoystickButton intakeButton;
 
  public void robotInit() {
    leftIntake = new TalonSRX(0);    // Explain that each motor controller has its own unique ID which is how the roborio identifies which one to run
    rightIntake = new TalonSRX(1);

    joystick = new Joystick(1);   //Explain that each USB Port has a distinct ID

    intakeButton = new JoystickButton(joystick, 3);     // Explain that there are distinct ID's for each button on a joystick

   m_robotContainer = new RobotContainer();
  }

  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

 
  public void disabledInit() {
  }


  public void disabledPeriodic() {
  }

  
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

 
  public void autonomousPeriodic() {
  }


  public void teleopInit() {
   
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }


  public void teleopPeriodic() {

    if(intakeButton.get() == true){
      leftIntake.set(ControlMode.PercentOutput, .3);
      rightIntake.set(ControlMode.PercentOutput, .3);
    }else{
      leftIntake.set(ControlMode.PercentOutput, 0);
      rightIntake.set(ControlMode.PercentOutput, 0);
    }

  }

  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  public void testPeriodic() {
  }
}
