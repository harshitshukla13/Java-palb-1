class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 1, high = 2000; // based on constraints
        int desired = (n * m) / 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;

            // count elements <= mid
            for (int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid);
            }

            if (count <= desired) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // helper method (binary search)
    private int upperBound(int[] row, int target) {
        int l = 0, r = row.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l; // number of elements <= target
    }
}