// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

public class IndexerSubsystem extends SubsystemBase {

    //says that these sparks exist
    private CANSparkMax HTMotor;
    private CANSparkMax HBMotor;
    private CANSparkMax VFMotor;
    private CANSparkMax VRMotor;
    //private MotorController IndexerSubs;
    
  public IndexerSubsystem(CANSparkMax HTMotor, CANSparkMax HBMotor, CANSparkMax VFMotor, CANSparkMax VRMotor) {
      //says they exist in this subsytem constructor bc we use subsytem to tell other files these exist too
      this.HTMotor = HTMotor;
      this.HBMotor = HBMotor;
      this.VFMotor = VFMotor;
      this.VRMotor = VRMotor;
  }


  /*

  //pretty sure these do nothing...

 

  public IndexerSubsystem(Subsystem Indexer, Subsystem vIndexMotor){

      vIndexMotor = Indexer;

  }

 

   */
  //makes motors move, H are reverse because they are installed backwards, so reverse is actually forward

  public void move(double speed){
    this.HTMotor.set(-speed);
    this.HBMotor.set(-speed);
    this.VFMotor.set(speed);
    this.VRMotor.set(speed);

  }


  //makes all motors stop

  public void stop(){
    this.HTMotor.set(0);
    this.HBMotor.set(0);
    this.VFMotor.set(0);
    this.VRMotor.set(0);

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