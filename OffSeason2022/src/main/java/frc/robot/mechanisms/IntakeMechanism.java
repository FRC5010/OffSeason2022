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
import frc.robot.commands.deployIntake;

/** Add your docs here. */
public class IntakeMechanism {
    
    // Declare Parts
    private CANSparkMax intakeMotor;
    private DoubleSolenoid intakeSolenoid;
    private IntakeSubsystem intakeSubsystem;
    private Controller driver;


    public IntakeMechanism(){

        // Initialize Parts
        intakeMotor = new CANSparkMax(7, MotorType.kBrushless);
        intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);
        //driver = new Controller(0);

        // Create Intake Subsystem
        intakeSubsystem = new IntakeSubsystem(intakeMotor, intakeSolenoid);
        

    }


    // Right trigger will put the intake down and spin it FORWARD
    // Left trigger will spin the intake in REVERSE
    // Only right trigger deploys intake
    // Applying more pressure to the trigger spins the intake faster
    public void configureButtonBindings(Controller driver, Controller coDriver) {
        driver.setLeftTrigger(driver.createLeftTrigger());
        Trigger intakeLT = new Trigger(() -> (Math.abs(driver.getLeftTriggerAxis()) > 0));

        driver.setRightTriggerAxis(driver.createRightTrigger());
        Trigger intakeRT = new Trigger(() -> (Math.abs(driver.getRightTriggerAxis()) > 0));

        intakeRT.whenActive(new deployIntake(intakeSubsystem, 0.0));
        
    }
}
