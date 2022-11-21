// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private CANSparkMax intakeMotor;
  private DoubleSolenoid intakeSolenoid;

  // Creates a new IntakeSubsystem.
  public IntakeSubsystem(CANSparkMax intakeMotor, DoubleSolenoid intakeSolenoid) {
    this.intakeMotor = intakeMotor;
    this.intakeSolenoid = intakeSolenoid;

  }

  // This method puts the intake DOWN
  public void intakeDown() {
    intakeSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  // This method puts the intake UP
  public void intakeUp() {
    intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  // This method sets the velocity of the motor
  public void spinIntake(double pow) {
    intakeMotor.set(pow);
  }

  // This method checks to see if the intake is already deployed
  public boolean getIntakeState() {
    return intakeSolenoid.get().equals(DoubleSolenoid.Value.kForward);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
