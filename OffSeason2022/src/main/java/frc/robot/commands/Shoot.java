// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.ResourceBundle.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.FRC5010.Controller;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
  /** Creates a new Shoot. */
  Shooter shooter;
  Controller controller;
  public Shoot(Shooter shooter, Controller controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter = shooter;
    addRequirements(shooter);
    this.controller = controller;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = controller.getRightTriggerAxis();
    double inverseSpin = controller.getLeftTriggerAxis();
    speed = speed-inverseSpin;
    
    if (Math.abs(speed) > 0) {
      shooter.shootRPM(speed*5000);
    } else {
      shooter.shoot(0);
    }
    //shooter.shoot(speed*.25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.shoot(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
