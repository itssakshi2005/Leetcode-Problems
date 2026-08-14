class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int index = -1;

        // Step 1: Find breakpoint
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // No breakpoint = last permutation
        if(index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find just greater element
        for(int i = n - 1; i > index; i--) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 3: Reverse the part after breakpoint
        reverse(nums, index + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}