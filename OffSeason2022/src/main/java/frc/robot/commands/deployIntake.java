// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.FRC5010.Controller;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

/** An example command that uses an example subsystem. */
public class deployIntake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem IntakeSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param intakeSubsystem The subsystem used by this command.
   */
  public deployIntake(IntakeSubsystem IntakeSubsystem, DoubleSolenoid intakeSolenoid) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(IntakeSubsystem);
    addRequirements(intakeSolenoid);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  public double getRTValue(Controller driver) {
    return driver.getRightTriggerAxis();
  }

  public double getLTValue(Controller driver) {
    return driver.getLeftTriggerAxis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
