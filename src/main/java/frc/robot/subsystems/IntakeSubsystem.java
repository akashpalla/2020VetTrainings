/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
 


  TalonSRX leftIntakeMotor, rightIntakeMotor, pivotMotor;
  DigitalInput topLimitSwitch, botLimitSwitch;


  public IntakeSubsystem() {
    leftIntakeMotor = new TalonSRX(32);
    rightIntakeMotor = new TalonSRX(21);
    pivotMotor = new TalonSRX(25);

    topLimitSwitch = new DigitalInput(2);
    botLimitSwitch = new DigitalInput(4);

    leftIntakeMotor.follow(rightIntakeMotor);
  }



  public void runIntake(){
    rightIntakeMotor.set(ControlMode.PercentOutput, 0.3);

  }

  public void stopIntake(){
    rightIntakeMotor.set(ControlMode.PercentOutput, 0);
  }

  public void pivotDown(){
    pivotMotor.set(ControlMode.PercentOutput, -0.6);
  }

  public void pivotUp(){
    pivotMotor.set(ControlMode.PercentOutput, 0.6);
  }

  public boolean getTopLimitSwitch() {
    return topLimitSwitch.get();
  }

  public boolean getBotLimitSwitch() {
    return botLimitSwitch.get();
  }


  public void stopPivotMotor(){
    pivotMotor.set(ControlMode.PercentOutput, 0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
