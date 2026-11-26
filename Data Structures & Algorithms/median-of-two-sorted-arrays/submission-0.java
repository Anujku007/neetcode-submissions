class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = 0;
        int high = n;

        int leftSize = (n + m + 1) / 2;

        while (low <= high) {

            int i = low + (high - low) / 2;
            int j = leftSize - i;

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == n) ? Integer.MAX_VALUE : nums1[i];

            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == m) ? Integer.MAX_VALUE : nums2[j];

            // Correct partition
            if (nums1Left <= nums2Right &&
                nums2Left <= nums1Right) {

                // Odd number of elements
                if ((n + m) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left);
                }

                // Even number of elements
                return (
                    Math.max(nums1Left, nums2Left) +
                    (double) Math.min(nums1Right, nums2Right)
                ) / 2.0;
            }

            // Move right in nums1
            else if (nums1Left > nums2Right) {
                high = i - 1;
            }

            // Move left in nums1
            else {
                low = i + 1;
            }
        }

        return 0.0;
    }
}