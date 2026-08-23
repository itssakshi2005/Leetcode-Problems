class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;      // nums1 ke last valid element par
        int j = n - 1;      // nums2 ke last element par
        int k = m + n - 1;  // nums1 ki last position par

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Agar nums2 ke elements bach gaye ho
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}