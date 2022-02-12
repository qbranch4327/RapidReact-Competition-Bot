package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionSubsystem extends SubsystemBase {
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry tx = table.getEntry("tx");
    private NetworkTableEntry ty = table.getEntry("ty");

    //read values periodically
    private double x = tx.getDouble(0.0);
    private double y = ty.getDouble(0.0);

    private double h1 = 48; //needs to be updated when placed on the robot
    private double h2 = 104;
    private double a1 = 45; //needs to be updated when placed on the robot


    public VisionSubsystem(){

    }

    public double getX(){
        return x;
    }

    public double getDistance(){
        double d = (h1-h2)/Math.tan(a1+y);
        return d;
    }
}
