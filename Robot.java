/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 * 
 * 
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
private VictorSPX leftMotor1 = new VictorSPX(1);
private VictorSPX leftMotor2 = new VictorSPX(10);
private VictorSPX rightMotor1 = new VictorSPX(0);
private VictorSPX rightMotor2 = new VictorSPX(5);

private Joystick joy1 = new Joystick(2);
private double startTime; 


  @Override
  public void robotInit() {

  }

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
double time = Timer.getFPGATimestamp();
System.out.println(time - startTime);

if (time - startTime < 3) {
    leftMotor1.set(ControlMode.PercentOutput, 0.5);
   leftMotor2.set(ControlMode.PercentOutput,0.5);
   rightMotor1.set(ControlMode.PercentOutput,-0.5);
   rightMotor2.set(ControlMode.PercentOutput,-0.5);
} else {
  leftMotor1.set(ControlMode.PercentOutput,0);
   leftMotor2.set(ControlMode.PercentOutput,0);
   rightMotor1.set(ControlMode.PercentOutput,0);
   rightMotor2.set(ControlMode.PercentOutput,0);
}
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double speed = -joy1.getRawAxis(1) * 1;
    double turn = joy1.getRawAxis(4) * 0.6;

    double left = speed + turn;
    double right = speed - turn;

   leftMotor1.set(ControlMode.PercentOutput,left);
   leftMotor2.set(ControlMode.PercentOutput,left);
   rightMotor1.set(ControlMode.PercentOutput,-right);
   rightMotor2.set(ControlMode.PercentOutput,-right);

  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
