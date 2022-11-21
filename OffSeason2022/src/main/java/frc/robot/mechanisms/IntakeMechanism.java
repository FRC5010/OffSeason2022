// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.mechanisms;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.FRC5010.Controller;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.DeployIntake;

/** Add your docs here. */
public class IntakeMechanism {
    
    // Declare Parts
    private CANSparkMax intakeMotor;
    private DoubleSolenoid intakeSolenoid;
    private IntakeSubsystem intakeSubsystem;


    public IntakeMechanism(){
        // Initialize Parts
        intakeMotor = new CANSparkMax(7, MotorType.kBrushless);
        intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);

        // Create Intake Subsystem
        intakeSubsystem = new IntakeSubsystem(intakeMotor, intakeSolenoid); 
    }


    // Right trigger will put the intake down and spin it FORWARD
    // Left trigger will spin the intake in REVERSE
    // Either trigger deploys intake
    // (RT - LT) / 2 = intakeSpeed
    public void configureButtonBindings(Controller driver, Controller coDriver) {
        // Define triggers
        driver.setLeftTrigger(driver.createLeftTrigger());
        driver.setRightTriggerAxis(driver.createRightTrigger());

        // Allow either trigger to activate command
        Trigger driverTriggers = new Trigger(() -> (Math.abs(driver.getRightTriggerAxis() + driver.getLeftTriggerAxis()) > 0));
        driverTriggers.whenActive(new DeployIntake(intakeSubsystem, 0, driver));
    }
}
