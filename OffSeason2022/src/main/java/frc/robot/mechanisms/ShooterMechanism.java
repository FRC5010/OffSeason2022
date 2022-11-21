// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// Shooter 13, 14, 15
// 14 and 15 have to be invert

package frc.robot.mechanisms;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;


import frc.robot.FRC5010.Controller;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Shooter;

/** Add your docs here. */
public class ShooterMechanism {
    CANSparkMax m13;
    CANSparkMax m14;
    CANSparkMax m15;
    Shooter shooter;
    public ShooterMechanism(){
        m13 = new CANSparkMax(13,MotorType.kBrushless);
        m14 = new CANSparkMax(14,MotorType.kBrushless);
        m15 = new CANSparkMax(15,MotorType.kBrushless);
        m13.restoreFactoryDefaults();
        m14.restoreFactoryDefaults();
        m15.restoreFactoryDefaults();
        m14.setInverted(true);
        m13.setInverted(true);
        m15.follow(m14, true);
        //Do the speed thingy, set up the button/input eater, how to spin it,  and thats it lol or more lol
        shooter = new Shooter(m14, m13);

    }

    public void configureButtonBindings(Controller driver, Controller coDriver) {
        driver.setRightTriggerAxis(driver.createRightTrigger().cubed());
        driver.setLeftTrigger(driver.createLeftTrigger().cubed());
        shooter.setDefaultCommand(new Shoot(shooter, driver));
    }
}
