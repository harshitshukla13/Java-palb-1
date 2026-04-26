class Solution {
    public int minSwaps(String s1, String s2) {
        int count01 = 0; // s1=0, s2=1
        int count10 = 0; // s1=1, s2=0

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if (a == '0' && b == '1') count01++;
            else if (a == '1' && b == '0') count10++;
        }

        // if total mismatches is odd → impossible
        if ((count01 + count10) % 2 != 0) return -1;

        int swaps = (count01 / 2) + (count10 / 2);

        // if both are odd → need 2 extra swaps
        if (count01 % 2 == 1) swaps += 2;

        return swaps;
    }
}