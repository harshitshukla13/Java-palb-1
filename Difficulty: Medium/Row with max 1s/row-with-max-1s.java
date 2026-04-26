class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int row = 0, col = m - 1;
        int maxRowIndex = -1;

        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                maxRowIndex = row;
                col--; // move left
            } else {
                row++; // move down
            }
        }

        return maxRowIndex;
    }
}