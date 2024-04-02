package trafficLight;

import java.util.logging.Logger;

public class Runner implements Runnable {
    volatile boolean isSystemOnline = true;
    final TrafficSignal signal;
    Logger logger = Logger.getLogger(Runner.class.getName());

    Runner(TrafficSignal signal){
        this.signal = signal;
    }

    public void stopRunner(){
        isSystemOnline = false;
        logger.info("Runner has stopped");
    }

    public void restartRunner(){
        if(!isSystemOnline){
            isSystemOnline = true;
        }
    }

    @Override
    public void run() {
        while(isSystemOnline){
            try {
                logger.info("Signal color:  "+signal.state.color.toString());
                Thread.sleep(signal.state.duration);
                signal.SetNextState();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
