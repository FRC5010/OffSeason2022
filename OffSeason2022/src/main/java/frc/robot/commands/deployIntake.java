// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.FRC5010.Controller;


/** An example command that uses an example subsystem. */
public class deployIntake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem IntakeSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param intakeSubsystem The subsystem used by this command.
   *
   */
  private final double intakeSpeed;
  private final IntakeSubsystem intakeSubsystem;
  public deployIntake(IntakeSubsystem intakeSubsystem, double intakeSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intakeSubsystem = intakeSubsystem;
    this.intakeSpeed = intakeSpeed;
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.intakeDown();
  }

  // Gets Axis value of the right trigger on the driver controller.
  public double getRTValue(Controller driver) {
    return driver.getRightTriggerAxis();
  }

  public double getLTValue(Controller driver) {
    return driver.getLeftTriggerAxis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

      // Vary motor velocity based on how far the trigger is pressed
      if (getRTValue(driver) >= 0.9) {
        intakeSpeed = 1.0;

      } else if (getRTValue(driver) >= 0.45) {
        intakeSpeed = 0.75;

      } else if (getRTValue(driver) >= -0.9) {
        intakeSpeed = 0.5;

      } else if (getRTValue(driver) >= -0.8) {
        intakeSpeed = 0.25;

      }

      // reverse the speed if the left trigger is pressed
      if (getLTValue(driver) >= -0.8) {
        intakeSpeed = -0.3;
      }

    // spin intake at desired speed
    intakeSubsystem.spinIntake(intakeSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.intakeUp();
    intakeSubsystem.spinIntake(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
