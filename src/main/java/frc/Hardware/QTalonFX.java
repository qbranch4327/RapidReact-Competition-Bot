package frc.Hardware;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class QTalonFX extends TalonFX {
    private final double decisecondsPerSecond = 10;
    private double ticksPerInch;
    private double saturationVoltage = 12;
    private int velocitySlotIdx;
    private int positionSlotIdx;
    private int lastSlot = 0;

    /**
     * Constructor
     *
     * @param deviceNumber [0,62]
     */
    public QTalonFX(int deviceNumber, double ticksPerInch, int positionSlotIdx, int velocitySlotIdx) {
        super(deviceNumber);
        this.ticksPerInch = ticksPerInch;
        this.velocitySlotIdx = velocitySlotIdx;
        this.positionSlotIdx = positionSlotIdx;
    }

    public double getDistanceMeters() {
        return (double) this.getSelectedSensorPosition() / ticksPerInch;
    }

    public double getRateMetersPerSecond() {
        return (double) this.getSelectedSensorVelocity() * decisecondsPerSecond / ticksPerInch;
    }

    public void setPercent(double percent) {
        this.set(ControlMode.PercentOutput, percent);
    }

    public void setVelocityMetersPerSecond(double velocityMetersPerSecond) {
        if (lastSlot != velocitySlotIdx) selectProfileSlot(velocitySlotIdx, 0);
        this.set(ControlMode.Velocity, velocityMetersPerSecond * ticksPerInch / decisecondsPerSecond);
    }

    public void setPositionMeters(double positionMeters) {
        if (lastSlot != positionSlotIdx) selectProfileSlot(positionSlotIdx, 0);
        this.set(ControlMode.Position, positionMeters * ticksPerInch);
    }

    public void setVoltage(double voltage) {
        this.set(ControlMode.PercentOutput, voltage / saturationVoltage);
    }

    @Override
    public void selectProfileSlot(int slotIdx, int pidIdx) {
        lastSlot = slotIdx;
        super.selectProfileSlot(slotIdx, pidIdx);
    }

    @Override
    public ErrorCode configVoltageCompSaturation(double voltage, int timeoutMs) {
        saturationVoltage = voltage;
        return super.configVoltageCompSaturation(voltage, timeoutMs);
    }

    @Override
    public ErrorCode configVoltageCompSaturation(double voltage) {
        saturationVoltage = voltage;
        return super.configVoltageCompSaturation(voltage);
    }
}