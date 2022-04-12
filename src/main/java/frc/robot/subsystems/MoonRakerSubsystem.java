package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoonRakerSubsystem extends SubsystemBase {
    private final double h1 = 32.5;
    private final double h2 = 104;
    private final double a1 = 43.6;
    private double x;
    private double y;
    private double d;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;

    public MoonRakerSubsystem() {
    }

    public void publishToDashboard() {
        // read values periodically
        SmartDashboard.putNumber("tx", x);
        SmartDashboard.putNumber("ty", y);
        SmartDashboard.putNumber("Distance", d);
    }

    public void update() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        publishToDashboard();
    }

    public double getX() {
        return x;
    }

    public double getDistance() {
        d = (h2 - h1) / (Math.tan((a1 + y)));
        return d;
    }
}
