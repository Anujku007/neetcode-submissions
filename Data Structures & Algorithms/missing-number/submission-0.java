class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalsum = n * (n + 1) / 2;
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            ans = totalsum - sum;
        }
        return ans;
    }
}
