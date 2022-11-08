// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.mechanisms;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.FRC5010.Controller;
import frc.robot.subsystems.IntakeSubsystem;

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

    // Methods to fetch trigger axis values
    public double getRTValue(Controller driver) {
        return driver.getRightTriggerAxis();
    }

    public double getLTValue(Controller driver) {
        return driver.getLeftTriggerAxis();
    }

    // Right trigger will put the intake down and spin it FORWARD
    // Left trigger will spin the intake in REVERSE
    // Only right trigger deploys intake
    // Applying more pressure to the trigger spins the intake faster
    public void configureButtonBindings(Controller driver, Controller coDriver) {

        
        // Trigger Deadzones of 0.2 (-1.0 to -0.8)

        // Use right trigger to set the intake state
        if (getRTValue(driver) >= -0.8) {
            if (intakeSubsystem.getIntakeState() == false) intakeSubsystem.intakeDown();

        } else {
            if (intakeSubsystem.getIntakeState() == true) intakeSubsystem.intakeUp();

        }

        // Motor speeds
        if (intakeSubsystem.getIntakeState() == true) {

            // If left trigger isn't pressed
            if (getLTValue(driver) < -0.8){

                // Vary motor velocity based on how far the trigger is pressed
                if (getRTValue(driver) >= 0.9) {
                    intakeSubsystem.spinIntake(1.0);

                } else if (getRTValue(driver) >= 0.45) {
                    intakeSubsystem.spinIntake(0.75);

                } else if (getRTValue(driver) >= -0.9) {
                    intakeSubsystem.spinIntake(0.5);

                } else if (getRTValue(driver) >= -0.8) {
                    intakeSubsystem.spinIntake(0.25);

                } else {
                    intakeSubsystem.spinIntake(0.0);

                }

            // Spin intake in reverse if the left trigger is pressed
            } else {
                intakeSubsystem.spinIntake(-0.5);

            }
        }
    }
}
