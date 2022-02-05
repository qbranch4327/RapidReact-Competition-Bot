// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.Hardware.QTalonFX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private final int CYCLES_PER_REVOLUTION = 2048;
    private final double CIRCUMFERENCE = 6 * 3.14159;
    private final double TICKS_PER_INCH = 434.68;
    private final int POSITION_SLOT = 0;
    private final int VELOCITY_SLOT = 1;

    // Set up drive motors
    private QTalonFX driveMotorLeftA = new QTalonFX(1, TICKS_PER_INCH, POSITION_SLOT, VELOCITY_SLOT);
    private QTalonFX driveMotorLeftB = new QTalonFX(2, TICKS_PER_INCH, POSITION_SLOT, VELOCITY_SLOT);
    private QTalonFX driveMotorRightA = new QTalonFX(3, TICKS_PER_INCH, POSITION_SLOT, VELOCITY_SLOT);
    private QTalonFX driveMotorRightB = new QTalonFX(4, TICKS_PER_INCH, POSITION_SLOT, VELOCITY_SLOT);

    private QTalonFX[] driveMotorLefts = new QTalonFX[] { driveMotorLeftA, driveMotorLeftB };
    private QTalonFX[] driveMotorRights = new QTalonFX[] { driveMotorRightA, driveMotorRightB };

    // Set up drive motor encoders
    private final Encoder leftEncoder = new Encoder(0, 1);
    private final Encoder rightEncoder = new Encoder(2, 3);

    private final double deadzone = 0.0;

    public DrivetrainSubsystem() {
        this.rightEncoder.setDistancePerPulse(CIRCUMFERENCE / CYCLES_PER_REVOLUTION);
        this.leftEncoder.setDistancePerPulse(CIRCUMFERENCE / CYCLES_PER_REVOLUTION);

        this.rightEncoder.setMaxPeriod(1);
        this.leftEncoder.setMaxPeriod(1);

        this.rightEncoder.setMinRate(10);
        this.leftEncoder.setMinRate(10);

        this.rightEncoder.setReverseDirection(true);
        this.leftEncoder.setReverseDirection(false);

        this.rightEncoder.setSamplesToAverage(5);
        this.leftEncoder.setSamplesToAverage(5);
    }

    public void setSpeed(double rightSpeed, double leftSpeed) {
        for (var motor : driveMotorLefts) {
            if (Math.abs(leftSpeed) > deadzone) {
                motor.setPercent(leftSpeed);
            } else {
                motor.setPercent(0);
            }
        }

        for (var motor : driveMotorRights) {
            if (Math.abs(rightSpeed) > deadzone) {
                motor.setPercent(-rightSpeed);
            } else {
                motor.setPercent(0);
            }
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
}