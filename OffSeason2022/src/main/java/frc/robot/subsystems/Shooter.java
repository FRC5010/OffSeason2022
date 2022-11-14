// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  RelativeEncoder shootEncoder;
  MotorController shooter;
  MotorController speedUp;
  
  public static double kSC = 0.11449;
  public static double kVC = 0.13197;

  public static double kS = kSC / 12;
  public static double kV = kVC / 60 / (12 - kS);

  /** Creates a new Shooter. */
  public Shooter(CANSparkMax shooter, MotorController speedUp) {
    this.shooter = shooter;
    this.speedUp = speedUp;
    shootEncoder = shooter.getEncoder();
  }

public void shootRPM (double RPM) {
  double speed = kS + kV * RPM;
  shooter.set(speed);
  speedUp.set(0.25);
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
