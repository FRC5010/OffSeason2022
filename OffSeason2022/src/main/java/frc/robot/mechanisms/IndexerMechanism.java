// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.mechanisms;

import frc.robot.FRC5010.Controller;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.FRC5010.Controller;

import frc.robot.subsystems.IndexerSubsystem;

import frc.robot.commands.IndexerForward;

import frc.robot.commands.IndexerBackward;

/** Add your docs here. */

public class IndexerMechanism {
    private CANSparkMax HTMotor;
    private CANSparkMax HBMotor;
    private CANSparkMax VFMotor;
    private CANSparkMax VRMotor;
    private IndexerSubsystem indexerSubsystem;


    public IndexerMechanism(){
        HTMotor = new CANSparkMax(8, MotorType.kBrushless);
        HBMotor = new CANSparkMax(9, MotorType.kBrushless);
        VFMotor = new CANSparkMax(11, MotorType.kBrushless);
        VRMotor = new CANSparkMax(10, MotorType.kBrushless);

        indexerSubsystem = new IndexerSubsystem(HTMotor, HBMotor, VFMotor, VRMotor);

    }


    public void configureButtonBindings(Controller driver, Controller coDriver) {

        coDriver.createAButton().whileHeld(new IndexerForward(indexerSubsystem));
        coDriver.createBButton().whileHeld(new IndexerBackward(indexerSubsystem));
    }

}