public class StopWatch {
    long start;
    long stop;

    public void startTime(){
        start=System.currentTimeMillis();
    }
    public void stopTime(){
        stop=System.currentTimeMillis();
    }

    public long getTotalTime(){
        return stop-start;
    }
}
