// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.mechanisms;
import java.beans.Encoder;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.FRC5010.Controller;
import frc.robot.commands.Turret_Left;
import frc.robot.subsystems.Turret;

/** Add your docs here. */
public class TurretMechanism {
    private CANSparkMax turret_motor;
    private Turret turret;
    private RelativeEncoder turretEncoder; 


    public TurretMechanism(){
        turret_motor = new CANSparkMax(16, MotorType.kBrushless);
        turret = new Turret(turret_motor);
        turretEncoder = turret_motor.getEncoder(); 
        System.out.println(turretEncoder); 
    }

    public void configureButtonBindings(Controller driver, Controller coDriver) {
        coDriver.createAButton().whileHeld(new Turret_Left(turret, 0.1));
        coDriver.createBButton().whileHeld(new Turret_Left(turret, -0.1));
    }}
