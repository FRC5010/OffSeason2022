// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class Turret_Left extends CommandBase {
  private double speed;
  private Turret turret;
  
  public Turret_Left(Turret turret, double speed) {
    addRequirements(turret);
    this.speed = speed;
    this.turret = turret;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turret.move(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {turret.stop();}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
