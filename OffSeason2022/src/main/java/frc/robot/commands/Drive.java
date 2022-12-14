// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.FRC5010.Controller;


public class Drive extends CommandBase {
  DriveTrain drivetrain;
  Controller controller;
  /** Creates a new Drive. */
  public Drive(DriveTrain driveTrain, Controller controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = driveTrain;
    this.controller = controller;
    addRequirements(driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double throttle = -controller.getLeftYAxis();
    double steer = controller.getRightXAxis();
    drivetrain.drive(throttle,steer);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
