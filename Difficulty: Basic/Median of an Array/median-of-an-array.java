
import java.util.*;

class Solution {
    public double findMedian(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;

        // odd length
        if (n % 2 == 1) {
            return arr[n / 2];
        }

        // even length
        return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
    }
}