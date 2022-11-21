// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.mechanisms;

import frc.robot.FRC5010.Controller;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.FRC5010.Controller;
import frc.robot.FRC5010.Controller.Axis;
import frc.robot.commands.BaseClimb;
import frc.robot.subsystems.ClimbSubsystem;


/** Add your docs here. */
public class ClimbMechanism {
    private ClimbSubsystem climbSubsystem;

    private JoystickButton climbButton;
    private JoystickButton deployClimbArmsButton;

    private CANSparkMax leftClimbMotor;
    private CANSparkMax rightClimbMotor;

    private DoubleSolenoid climbSolenoid;
    

    public ClimbMechanism(){
        leftClimbMotor = new CANSparkMax(6, MotorType.kBrushless);
        rightClimbMotor = new CANSparkMax(5, MotorType.kBrushless);

        leftClimbMotor.setInverted(false);
        rightClimbMotor.setInverted(true);

        climbSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 2, 3);
        climbSolenoid.set(Value.kReverse);

        climbSubsystem = new ClimbSubsystem(leftClimbMotor, rightClimbMotor, climbSolenoid);

    }
    


    public void configureButtonBindings(Controller driver, Controller coDriver) {
        climbButton = driver.createLeftBumper();
        deployClimbArmsButton = coDriver.createStartButton();


        coDriver.setLeftYAxis(coDriver.createLeftYAxis());
        coDriver.setRightYAxis(coDriver.createRightYAxis());

        climbButton.whileHeld(new BaseClimb(climbSubsystem, coDriver));
        deployClimbArmsButton.whenActive(new InstantCommand(() -> {climbSubsystem.toggleSolenoid();}, climbSubsystem));
        


    }
}
