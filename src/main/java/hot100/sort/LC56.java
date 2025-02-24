package hot100.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author xunfangce
 * @create 2024/12/13
 */
public class LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(v -> v[0]));

        for (int i = 1; i < intervals.length; i++) {

        }
    }

    private void mergeTwoRange(int[] range1, int[] range2) {

    }

}
