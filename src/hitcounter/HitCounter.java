package hitcounter;

public class HitCounter {
    private int[] times ;
    private int[] hits;

    public HitCounter(int window){
        times = new int[window];
        hits = new int[window];
    }


    private void recordHit(int timeStamp, int hit){
        int time = timeStamp % times.length;

        if(times[time]==timeStamp){
            hits[time]+=hit;
        }else{
            times[time]=timeStamp;
            hits[time]=1;
        }
    }

    private int getHitsInLastWindow(int timeStamp){
        int sum = 0;

        for(int t: times) {
            if (t - timeStamp < times.length) {
                sum += hits[t];
            }
        }
        return sum;
    }

}
