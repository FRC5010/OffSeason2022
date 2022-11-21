// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.mechanisms;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.FRC5010.Controller;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;

/** Add your docs here. */
public class DrivetrainMechanism {
    CANSparkMax m1;
    CANSparkMax m2;
    CANSparkMax m3;
    CANSparkMax m4;
    DriveTrain drivetrain;
    public DrivetrainMechanism(){
        m1 = new CANSparkMax(1,MotorType.kBrushless);
        m2 = new CANSparkMax(2,MotorType.kBrushless);
        m3 = new CANSparkMax(3,MotorType.kBrushless);
        m4 = new CANSparkMax(4,MotorType.kBrushless);
        m1.restoreFactoryDefaults();
        m2.restoreFactoryDefaults();
        m3.restoreFactoryDefaults();
        m4.restoreFactoryDefaults();
        m1.setInverted(false);
        m2.setInverted(true);
        m3.follow(m1,false);
        m4.follow(m2,false);
        drivetrain = new DriveTrain(m1, m2);
    }

    public void configureButtonBindings(Controller driver, Controller coDriver) {
        drivetrain.setDefaultCommand(new Drive(drivetrain,driver));
    }
}
