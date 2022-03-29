
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  //Variables
  //Wheels' velocity
  double leftSlow = 0.25;
  double rightSlow = 0.24;

  //Rotation Speed
  double rotateSpeed = 0.35;
  double rotateSpeedSlow = 0.25; 

  @Override
  public void robotInit() {
  }


  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  
  @Override
  public void autonomousPeriodic() {
  
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
