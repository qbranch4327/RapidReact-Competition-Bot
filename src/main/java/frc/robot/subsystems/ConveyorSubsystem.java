package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

public class ConveyorSubsystem {

    private CANSparkMax motor1;
    private CANSparkMax motor2;

    public ConveyorSubsystem(CANSparkMax motor1, CANSparkMax motor2){
        this.motor1 = motor1;
        this.motor2 = motor2;
    }

    public void start() {
        this.motor1.set(0.5);
        this.motor2.set(0.5);
    }

    public void stop() {
        this.motor1.set(0);
        this.motor2.set(0);
    }

}
