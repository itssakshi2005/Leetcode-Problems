class Solution {
public int firstStableIndex(int[] nums, int k) {
int n = nums.length;
    for (int i = 0; i < n; i++) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // max from 0 to i
        for (int j = 0; j <= i; j++) {
            max = Math.max(max, nums[j]);
        }

        // min from i to n-1
        for (int j = i; j < n; j++) {
            min = Math.min(min, nums[j]);
        }

        int score = max - min;

        if (score <= k) {
            return i;
        }
    }

    return -1;
}


}
