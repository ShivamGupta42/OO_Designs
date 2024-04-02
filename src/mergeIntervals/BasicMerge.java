package mergeIntervals;


import java.util.*;

class BasicMerge {

    public static void main(String[] args) {
        int[][] res = mergeIntervals(new int[][]{new int[]{1,2}, new int[]{2,3}});
        printInterval(res);
    }
    public static int[][] mergeIntervals(int[][] intervals) {
        if(intervals ==null||intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] lastMergedInterval = list.get(list.size()-1);
            int[] curInterval = intervals[i];

            if(curInterval[0]<=lastMergedInterval[1]){
                list.remove(list.size()-1);
                list.add(new int[]{lastMergedInterval[0],lastMergedInterval[1]>=curInterval[1]?lastMergedInterval[1]:curInterval[1]});
            }else{
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][]);

    }

    private static void printInterval(int[][] interval){
        for(int[] arr: interval){
            System.out.println(" %s : %s ".formatted(arr[0],arr[1]));
        }
    }
}

