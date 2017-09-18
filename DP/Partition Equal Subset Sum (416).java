public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        
        return dp[sum];
    }
}
