package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {


    public static void main(String[] args) {
        int[][] existingIntervals = new int[][]{new int[]{1, 3}, new int[]{4, 5}, new int[]{7, 8}, new int[]{9, 12}, new int[]{13, 14}};
        int[] newInterval = new int[]{2, 10};
        MergeIntervals.printInterval(insertInterval(existingIntervals, newInterval));
    }

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < existingIntervals.length; i++) {

            if (existingIntervals[i][0] < newInterval[0]) {
                res.add(existingIntervals[i]);
                continue;
            }

            if (res.size() == 0) {
                res.add(newInterval);
            } else {
                int[] lastMergedInterval = res.get(res.size() - 1);
                if (lastMergedInterval[1] >= newInterval[0]) {
                    res.remove(res.size() - 1);
                    res.add(new int[]{lastMergedInterval[0], lastMergedInterval[1] >= existingIntervals[i][1] ? lastMergedInterval[1] : existingIntervals[i][1]});
                } else {
                    res.add(existingIntervals[i]);
                }
            }

        }
        return res.toArray(new int[res.size()][]);
    }
}


