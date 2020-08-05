/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeCommand;

/**
 * Add your docs here.
 */
public class OI {
    
    
    Joystick joystick;
    JoystickButton intakeButton;

    public OI(){
        joystick = new Joystick(1);
        intakeButton = new JoystickButton(joystick, 4);

        intakeButton.whenPressed(new IntakeCommand());

    }

    // Returns true if intakeButton is pressed, false otherwise
    public boolean getIntakeButton(){
        return intakeButton.get();
    }


    // wheel/turn
    public double getX(){
        return joystick.getRawAxis(6);
    }

    //throttle
    public double getY(){
        return joystick.getRawAxis(5);
    }




}
