import java.util.*;

class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // count visible to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }

        stack.clear();

        // count visible to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (n - 1 - i) : stack.peek() - i - 1;
            stack.push(i);
        }

        int maxSeen = 0;

        for (int i = 0; i < n; i++) {
            int total = left[i] + right[i] + 1; // include self
            maxSeen = Math.max(maxSeen, total);
        }

        return maxSeen;
    }
}