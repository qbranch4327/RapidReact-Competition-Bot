package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.ArrayList;
import java.util.Collection;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;

public class MusicSubsystem {
    private final Orchestra orchestra; 

    public MusicSubsystem(ArrayList<TalonFX> instruments) {
        orchestra = new Orchestra(instruments);
    }

    public void load(String filepath) {
        orchestra.loadMusic(filepath);
    }

    public void play() {
        orchestra.play();
    }
}
