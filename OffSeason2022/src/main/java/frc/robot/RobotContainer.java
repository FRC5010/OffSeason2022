// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.FRC5010.Controller;
import frc.robot.commands.ExampleCommand;
import frc.robot.mechanisms.ClimbMechanism;
import frc.robot.mechanisms.DrivetrainMechanism;
import frc.robot.mechanisms.IndexerMechanism;
import frc.robot.mechanisms.IntakeMechanism;
import frc.robot.mechanisms.ShooterMechanism;
import frc.robot.mechanisms.TurretMechanism; 
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private Controller driver = new Controller(0);
  private Controller coDriver = new Controller(1);
  
  private ClimbMechanism climbMechanism;
  private DrivetrainMechanism drivetrainMechanism;
  private IndexerMechanism indexerMechanism;
  private IntakeMechanism intakeMechanism;
  private ShooterMechanism shooterMechanism;
  private TurretMechanism turretMechanism;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    climbMechanism = new ClimbMechanism();
    drivetrainMechanism = new DrivetrainMechanism();
    indexerMechanism = new IndexerMechanism();
    intakeMechanism = new IntakeMechanism();
    shooterMechanism = new ShooterMechanism();
    turretMechanism = new TurretMechanism();
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driver.setLeftYAxis(driver.createLeftYAxis());
    driver.setRightXAxis(driver.createRightXAxis());
    
    climbMechanism.configureButtonBindings(driver, coDriver);
    drivetrainMechanism.configureButtonBindings(driver, coDriver);
    indexerMechanism.configureButtonBindings(driver, coDriver);
    intakeMechanism.configureButtonBindings(driver, coDriver);
    shooterMechanism.configureButtonBindings(driver, coDriver);
    turretMechanism.configureButtonBindings(driver, coDriver);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
