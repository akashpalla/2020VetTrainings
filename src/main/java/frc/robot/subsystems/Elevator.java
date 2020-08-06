/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  /**
   * Creates a new Elevator.
   */

  double kP, kI, kD;
  double targetPosition = 20000; 

  TalonSRX elevatorMaster, elevatorFollower;
  public Elevator() {

    kP = 0.0255;

    elevatorFollower = new TalonSRX(0);
    elevatorMaster = new TalonSRX(1);

    elevatorFollower.follow(elevatorMaster);

    elevatorMaster.setSensorPhase(true);
    elevatorMaster.setInverted(false);

    elevatorMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    elevatorMaster.config_kP(0, kP);
    elevatorMaster.config_kI(0, kI);
    elevatorMaster.config_kD(0, kD);


  }

  public void periodic() {

    elevatorMaster.set(ControlMode.Position, targetPosition);


  }
}
