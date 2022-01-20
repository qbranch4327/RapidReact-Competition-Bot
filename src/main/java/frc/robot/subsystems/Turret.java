package frc.robot.subsystems;

public class Turret {
    public ShooterSubsystem(Falcon turret){
        this.turret = turret;
    }

    public void clockwise(){ //will insert info from vision system to parameters
        turret.set(speed);
        //speed to be determined
        //when encoder reaches blank from vision system
        turret.stopMotor();
    }

    public void counterclockwise(){ //will insert info from vision system to parameters
        turret.set(-speed);//tbd
        //when encoder reaches blank
        turret.stopMotor();
    }

}
