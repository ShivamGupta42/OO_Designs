package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class minHeapTest {


    static class Point{
        final int x;
        final int y ;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int distanceToOriginSquared(){
            return x*x+y*y;
        }

        @Override
        public String toString() {
            return "X : %d, Y : %d".formatted(x,y);
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Point> q = new PriorityQueue<>((a,b)->a.distanceToOriginSquared() - b.distanceToOriginSquared());
        q.add(new Point(1,1));
        q.add(new Point(2,2));
        q.add(new Point(3,3));

        System.out.println(new ArrayList<>(q));
    }
}
