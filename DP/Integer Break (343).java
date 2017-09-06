public class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            int product = 1;
            
            while (n > 4) {
                product *= 3;
                n -= 3;
            }
            
            product *= n;
            return product;
        }
    }
}

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
            }
        }
        
        return dp[n];
    }
}
