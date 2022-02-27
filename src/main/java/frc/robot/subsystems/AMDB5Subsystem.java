// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AMDB5Subsystem extends SubsystemBase {
    private final int CYCLES_PER_REVOLUTION = 2048;
    private final double CIRCUMFERENCE = 6 * 3.14159;

    // Set up drive motors

    private TalonFX driveMotorLeftA = new TalonFX(11);
    private TalonFX driveMotorLeftB = new TalonFX(2);
    private TalonFX driveMotorRightA = new TalonFX(3);
    private TalonFX driveMotorRightB = new TalonFX(4);

    // Set up drive motor encoders
    private final Encoder leftEncoder = new Encoder(0, 1);
    private final Encoder rightEncoder = new Encoder(2, 3);

    private final double deadzone = 0.0;

    public AMDB5Subsystem() {
        this.rightEncoder.setMaxPeriod(1);
        this.leftEncoder.setMaxPeriod(1);

        this.rightEncoder.setMinRate(10);
        this.leftEncoder.setMinRate(10);

        this.rightEncoder.setReverseDirection(true);
        this.leftEncoder.setReverseDirection(false);

        this.rightEncoder.setSamplesToAverage(5);
        this.leftEncoder.setSamplesToAverage(5);

    //    driveMotorLeftA.setInverted(TalonFXInvertType.Clockwise);
        driveMotorRightA.setInverted(TalonFXInvertType.Clockwise);

        driveMotorRightB.follow(driveMotorRightA);
        driveMotorLeftB.follow(driveMotorLeftA);

        driveMotorLeftB.setInverted(InvertType.FollowMaster);
        driveMotorRightB.setInverted(InvertType.FollowMaster);

        rightEncoder.setDistancePerPulse(CIRCUMFERENCE / CYCLES_PER_REVOLUTION);
        leftEncoder.setDistancePerPulse(CIRCUMFERENCE / CYCLES_PER_REVOLUTION);
    }

    public void setSpeed(double rightSpeed, double leftSpeed) {

        if (Math.abs(rightSpeed) > deadzone) {
            driveMotorRightA.set(ControlMode.PercentOutput, rightSpeed);
        } 
        else {
            driveMotorRightA.set(ControlMode.PercentOutput, 0);
        }

        if (Math.abs(leftSpeed) > deadzone) {
            driveMotorLeftA.set(ControlMode.PercentOutput, leftSpeed);
        } 
        else {
            driveMotorLeftA.set(ControlMode.PercentOutput, 0);
        }

        double difference = rightEncoder.getDistance() - leftEncoder.getDistance();
        double percent = Math.abs((rightEncoder.getDistance() + leftEncoder.getDistance())/rightEncoder.getDistance());
        if (difference > 0 && percent > .05){
            rightSpeed -= .05;
        }
        if (difference < 0 && percent > .05){
            leftSpeed -= .05;
        }
    }

    public void resetEncoders() {
        this.leftEncoder.reset();
        this.rightEncoder.reset();
    }

    public double getLeftEncoderDistanceInches() {
        return this.leftEncoder.getDistance();
    }

    public double getRightEncoderDistanceInches() {
        return this.rightEncoder.getDistance();
    }

    public void publishToDashboard() {
        SmartDashboard.putNumber("rightEncoder", rightEncoder.getDistance());
        SmartDashboard.putNumber("rightEncoder DPP", rightEncoder.getDistancePerPulse());
        SmartDashboard.putNumber("leftEncoder", leftEncoder.getDistance());
        SmartDashboard.putNumber("leftEncoder DPP", leftEncoder.getDistancePerPulse());
    }

    public TalonFX speaker1(){
       return driveMotorLeftA; 
    }

    public TalonFX speaker2(){
        return driveMotorLeftA;
    }
}