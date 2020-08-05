/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class PivotUpCommand extends CommandBase {
  /**
   * Creates a new PivotUpommand.
   */
  public PivotUpCommand() {
    addRequirements(Robot.intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  public void initialize() {
  
  }


  public void execute() {
    Robot.intake.pivotUp();
  }

 
  public void end(boolean interrupted) {
    Robot.intake.stopPivotMotor();

  }


  public boolean isFinished() {
    return Robot.intake.getTopLimitSwitch();
  }
}
