import java.util.Arrays;

public class Sensor {
    String location;
    double reading;

    public void init(double reading){
        if (reading < -50.0 || reading > 50.0){
            this.reading=0.0;
        }
        else this.reading=reading;
    }
    public double average(double[] sensors){
        return Arrays.stream(sensors).sum()/sensors.length;
    }
}
