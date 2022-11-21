// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  MotorController shooter;
  MotorController speedUp;
  /** Creates a new Shooter. */
  public Shooter(MotorController shooter, MotorController speedUp) {
    this.shooter = shooter;
    this.speedUp = speedUp;

  }

public void shoot (double speed){
  shooter.set(speed);
  speedUp.set(speed);
  
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
