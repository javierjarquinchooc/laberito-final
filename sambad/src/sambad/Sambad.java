package sambad;
 
 
import simbad.gui.Simbad; 
import simbad.sim.*; 
import javax.vecmath.Vector3d; 
import javax.vecmath.Vector3f; 
 
 
/**
  Derivate your own code from this example. 
 */ 
 
 
public class Sambad { 
 
    /** Describe the robot */ 
    static public class Robot extends Agent { 
 
        RangeSensorBelt sonars; 
        CameraSensor camera; 
   
        public Robot(Vector3d position, String name) { 
            super(position, name); 
            // Add camera 
            camera = RobotFactory.addCameraSensor(this);
     
           
            // Add sonars 
            sonars = RobotFactory.addSonarBeltSensor(this); 
        } 
 
        /** This method is called by the simulator engine on reset. */ 
        public void initBehavior() { 
            // nothing particular in this case 
        } 
 
        /** This method is call cyclically (20 times per second)  by the simulator engine. */ 
        public void performBehavior() { 
 
            // progress at 0.5 m/s 
            setTranslationalVelocity(1); 
            
            // frequently change orientation 
            if ((getCounter() % 100) == 0) 
                setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random())); 
 
            // print front sonar every 100 frames 
            if (getCounter() % 100 == 0) 
                System.out 
                        .println("Sonar num 0  = " + sonars.getMeasurement(0)); 
 
        } 
    } 
 
    /** Describe the environement */ 
    static public class MyEnv extends EnvironmentDescription { 
        public MyEnv() { 
            light1IsOn = true; 
            light2IsOn = false; 
            Wall w11 = new Wall(new Vector3d(-7, 0, 1), 16,1, this); 
            w11.rotate90(1); 
            add(w11); 
            Wall w12 = new Wall(new Vector3d(-9, 0, 0), 19, 1, this); 
            w12.rotate90(1); 
            add(w12); 
            
            //
               Wall w13 = new Wall(new Vector3d(-6, 0, -7), 2, 1, this); 
            w13.rotate90(0); 
            add(w13); 
            Wall w14 = new Wall(new Vector3d(-3, 0, -7), 4, 1, this); 
            w14.rotate90(1); 
            add(w14); 
            Wall w15 = new Wall(new Vector3d(-3, 0, 0), 5, 1, this); 
            w15.rotate90(1); 
            add(w15); 
            Wall w16 = new Wall(new Vector3d(-4, 0, 0), 2, 1, this); 
       
            add(w16);
            //
                  //
               Wall w17 = new Wall(new Vector3d(-1, 0, -6), 6, 1, this); 
            w17.rotate90(1); 
            add(w17); 
            Wall w18 = new Wall(new Vector3d(-5, 0, 4.5), 4, 1, this); 
            w18.rotate90(0); 
            add(w18); 
            Wall w19 = new Wall(new Vector3d(-3, 0, 7.5), 3, 1, this); 
            w19.rotate90(1); 
            add(w19); 
            Wall w20 = new Wall(new Vector3d(-1, 0, 5), 8, 1, this); 
           w20.rotate90(1);
       
            add(w20);
            //
            
                         //
               Wall w21 = new Wall(new Vector3d(1, 0,0), 12, 1, this); 
            w21.rotate90(1); 
            add(w21); 
            Wall w22 = new Wall(new Vector3d(2, 0, -6), 2, 1, this); 
            w22.rotate90(0); 
            add(w22); 
            Wall w23 = new Wall(new Vector3d(3, 0, -6.5), 5, 1, this); 
            w23.rotate90(1); 
            add(w23); 
            Wall w24 = new Wall(new Vector3d(3, 0, 4), 10, 1, this); 
           w24.rotate90(1);
       
            add(w24);
            //
                             //
               Wall w25 = new Wall(new Vector3d(5, 0,-1), 12, 1, this); 
            w25.rotate90(1); 
            add(w25); 
            Wall w26 = new Wall(new Vector3d(4, 0, 5), 2, 1, this); 
            w26.rotate90(0); 
            add(w26); 
            Wall w27 = new Wall(new Vector3d(7, 0, -1.5), 15, 1, this); 
            w27.rotate90(1); 
            add(w27); 
            Wall w28 = new Wall(new Vector3d(3, 0, 4), 10, 1, this); 
           w28.rotate90(1);
       
            add(w28);
            //
            Wall w1 = new Wall(new Vector3d(9, 0, 1.5), 15, 1, this); 
            w1.rotate90(1); 
            add(w1); 
            Wall w2 = new Wall(new Vector3d(-9, 0, 0), 19, 1, this); 
            w2.rotate90(1); 
            add(w2); 
            Wall w3 = new Wall(new Vector3d(0, 0, 9), 19, 1, this); 
            add(w3); 
            Wall w4 = new Wall(new Vector3d(0, 0, -9), 19, 1, this); 
            add(w4); 
           
      
            add(new Robot(new Vector3d(-8, 0,8), "robot 1")); 
 
        } 
    } 
 
    public static void main(String[] args) { 
        // request antialising 
        System.setProperty("j3d.implicitAntialiasing", "true"); 
        // create Simbad instance with given environment 
        Simbad frame = new Simbad(new MyEnv(), false); 
    } 
 
} 