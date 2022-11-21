// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.FRC5010.Controller;


/** An example command that uses an example subsystem. */
public class DeployIntake extends CommandBase {
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
  public DeployIntake(IntakeSubsystem intakeSubsystem, double intakeSpeed) {
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

    // Calculate intake speed
      // Right Trigger is forward, left is reverse
      // Spin intake at half speed for safety reasons
    intakeSpeed = (driver.getRightTriggerAxis() - driver.getLeftTriggerAxis()) / 2;
    
    
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
