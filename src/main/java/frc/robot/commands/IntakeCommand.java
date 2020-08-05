/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IntakeCommand extends CommandBase {
  /**
   * Creates a new IntakeCommand.
   */
  public IntakeCommand() {
    addRequirements(Robot.intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Check if pivot has reached bottom then run intake motor
    if(Robot.intake.getBotLimitSwitch() == true){
      Robot.intake.runIntake();
      Robot.intake.stopPivotMotor();
    }else{
      Robot.intake.pivotDown();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.intake.stopIntake();
    new PivotUpCommand().schedule();
    
  }

  // Returns true when the command should end.
  //Returns true when button is not pressed, false otherwise
  @Override
  public boolean isFinished() {
    return !(Robot.oi.getIntakeButton());
  }
}
