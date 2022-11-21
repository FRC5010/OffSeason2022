// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private MotorController turret_motor;
  
  public Turret(MotorController turret) {
    turret_motor = turret;
  }
public void move(double speed) {
  turret_motor.set(speed);
}
public void stop() {
  turret_motor.set(0);
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
