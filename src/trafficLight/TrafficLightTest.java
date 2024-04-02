package trafficLight;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TrafficLightTest {


    public static void main(String[] args) throws InterruptedException {
        TrafficSignal signal = new TrafficSignal();
        Runner runner = new Runner(signal);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(runner);
        Thread.sleep(5000);
        runner.stopRunner();
        executor.shutdown();
        Thread.sleep(1000);
    }
}
