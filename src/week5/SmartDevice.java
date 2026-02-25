public class SmartDevice {
    private String brand;
    private boolean isPowerOn;

    public SmartDevice(String brand, boolean isPowerOn){
        this.brand=brand;
        this.isPowerOn=isPowerOn;
    }

    public String toString(){
        return brand + " " + (isPowerOn ? "On" : "Off");
    }
}
class Hub<T>{
    private T device;

    public void storeDevice(T item){
        this.device = item;
    }
    public T getDevice(){
        return this.device;
    }
    public void statusReport(){
        if (device != null){
            System.out.printf(device.toString());
        }
        else System.out.print("No device");
    }
}
