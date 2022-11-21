// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  private CANSparkMax leftClimbMotor;
  private CANSparkMax rightClimbMotor;

  private DoubleSolenoid climbSolenoid;

  private RelativeEncoder leftClimbEncoder;
  private RelativeEncoder rightClimbEncoder;

  /** Creates a new ClimbSubsystem. */
  public ClimbSubsystem(CANSparkMax leftClimbMotor, CANSparkMax rightClimbMotor, DoubleSolenoid climbSolenoid) {
    this.climbSolenoid = climbSolenoid;
  

    this.leftClimbMotor = leftClimbMotor;
    this.rightClimbMotor = rightClimbMotor;

    this.leftClimbEncoder = leftClimbMotor.getEncoder();
    this.rightClimbEncoder = rightClimbMotor.getEncoder();

    resetEncoders();

  }

  public double scaleClimbInputs(double input) {
    // Applies Deadzones 
    if (input > -0.75 && input < 0.75) {
      return 0;
    }
    if (input > 1) {
      return 1;
    } else if (input < -1) {
      return -1;
    }

    return Math.pow(input, 3);
  }

  public double getLeftEncoder() {
    return leftClimbEncoder.getPosition();
  }

  public double getRightEncoder() {
    return rightClimbEncoder.getPosition();
  }

  public void setLeftMotorSpeed(double speed) {
    leftClimbMotor.set(speed);
  }

  public void setRightMotorSpeed(double speed) {
    rightClimbMotor.set(speed);
  }

  public void toggleSolenoid() {
    climbSolenoid.toggle();
  }

  public void resetEncoders() {
    this.leftClimbEncoder.setPosition(0);
    this.rightClimbEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
