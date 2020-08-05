/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.TeleopDriveCommand;

public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSubsystem.
   */


  WPI_TalonSRX leftFront, rightFront, leftBack, rightBack;
  SpeedControllerGroup leftMotors, rightMotors;
  DifferentialDrive drivetrain;

  public DrivetrainSubsystem() {

    leftFront = new WPI_TalonSRX(0);
    rightFront = new WPI_TalonSRX(1);
    leftBack = new WPI_TalonSRX(2);
    rightBack = new WPI_TalonSRX(3);

    leftMotors = new SpeedControllerGroup(leftBack, leftFront);
    rightMotors = new SpeedControllerGroup(rightBack, rightFront);

    drivetrain = new DifferentialDrive(leftMotors, rightMotors);


    setDefaultCommand(new TeleopDriveCommand());

  }


  public void driveWithJoystick(double Y, double X){
    drivetrain.arcadeDrive(Y, X);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
