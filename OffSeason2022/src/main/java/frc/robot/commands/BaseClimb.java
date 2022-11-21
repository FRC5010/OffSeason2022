// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.FRC5010.Controller;
import frc.robot.subsystems.ClimbSubsystem;

public class BaseClimb extends CommandBase {

  Controller controller;
  ClimbSubsystem climbSubsystem;

  /** Creates a new BaseClimb. */
  public BaseClimb(ClimbSubsystem climbSubsystem, Controller climbController) {
    this.controller = climbController;
    this.climbSubsystem = climbSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climbSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rightSpeed = climbSubsystem.scaleClimbInputs(-controller.getRightYAxis());
    if (climbSubsystem.getRightEncoder() < Constants.climbMax || rightSpeed < 0) {
      climbSubsystem.setRightMotorSpeed(rightSpeed);
    } else {
      climbSubsystem.setRightMotorSpeed(0);
    }

    double leftSpeed = climbSubsystem.scaleClimbInputs(-controller.getLeftYAxis());
    if (climbSubsystem.getLeftEncoder() < Constants.climbMax || leftSpeed < 0) {
      climbSubsystem.setLeftMotorSpeed(leftSpeed);
    } else {
      climbSubsystem.setLeftMotorSpeed(0);
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbSubsystem.setLeftMotorSpeed(0);
    climbSubsystem.setRightMotorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
