// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  MotorController left;
  MotorController right;
  DifferentialDrive diffDrive;
  /** Creates a new DriveTrain. */
  public DriveTrain(MotorController left,MotorController right) {
    this.left = left;
    this.right = right;
    diffDrive = new DifferentialDrive(left,right);
  }
  public void drive(double throttle,double steer){
    diffDrive.arcadeDrive(throttle, steer);
  }
  public void stop(){
    diffDrive.arcadeDrive(0, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
