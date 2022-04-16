
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  //Variables
  //Wheels' velocity
  double leftSlow = 0.25;
  double rightSlow = 0.24;

  //Rotation Speed
  double rotateSpeed = 0.35;
  double rotateSpeedSlow = 0.25; 

  //Inputs
  AnalogGyro gyro = new AnalogGyro(0); //(The changing to NavX to test later) (Max of the example gyro is 300 deg)
  
  //Outputs:
  WPI_TalonSRX leftMotor = new WPI_TalonSRX(0);
  WPI_TalonSRX rightMotor = new WPI_TalonSRX(1);
  Servo servoCamera = new Servo(2);


  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture(0);
    gyro.reset();
    //Reset the gyro everytime the robot is turned on, the Camera starts and the gyro reset
  }


  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    gyro.reset();
    //Reset everytime Auto is on
  }

  
  @Override
  public void autonomousPeriodic() {
    //Some written random Maths algorithms not by me
    if (Math.abs(gyro.getAngle()) <= 3) {
      leftMotor.set(leftSlow - (gyro.getAngle()/15));
      rightMotor.set(rightSlow - (gyro.getAngle()/15));
      //If the PID Controller turns no more than 3 degrees
    } else if (Math.abs(gyro.getAngle()) < 10) {
      if (gyro.getAngle() > 0) {
        leftMotor.set(leftSlow);
        rightMotor.set(rightSlow * 1.1);
      }
      if (gyro.getAngle() < 0) {
        rightMotor.set(rightSlow);
        leftMotor.set(rightSlow * 1.1);
      }
    } else if (gyro.getAngle() > 0){
      while (gyro.getAngle() > 10 && isAutonomous()) {
        leftMotor.set(-rotateSpeed);
        rightMotor.set(-rotateSpeed);
      } 
    } else {
      while (gyro.getAngle() <-10 && isAutonomous()) {
        leftMotor.set(rotateSpeed);
        rightMotor.set(rotateSpeed);
      }
    }
  }

  @Override
  public void teleopInit() {
    //Upon starting teleOP, the initial speed is set to 0 for both motors
    leftMotor.set(0);
    rightMotor.set(0);
  }

  @Override
  public void teleopPeriodic() {
    //Previewing the output of gyro's angle
    System.out.println(Math.round(gyro.getAngle()));
    //Printing the number in the command prompts (probability: 0 to 1 degrees ko chech nhieu the dau lol)

    //Setting servo as Gimbal
    servoCamera.set(0.5 - gyro.getAngle()/175); 
    //NOTE: I don't really know about this algorthms so i'm just a copy cat tho smth ik is that it moves pretty slow
  } 
}
