// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.FRC5010.Controller;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.mechanisms.IntakeMechanism;


/** An example command that uses an example subsystem. */
public class deployIntake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  // private final IntakeSubsystem intakeSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param intakeSubsystem The subsystem used by this command.
   *
   */
  private double intakeSpeed;
  private final IntakeSubsystem intakeSubsystem;
  private Controller driver;
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

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    intakeSpeed = driver.getRightTriggerAxis();

    // reverse the speed if the left trigger is pressed
    if (driver.getLeftTriggerAxis() >= 0.2) {
      intakeSpeed = -0.3;
    }

    // reverse when left trigger is active
    IntakeMechanism.intakeLT.whenHeld(intakeSpeed = -0.3);

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
