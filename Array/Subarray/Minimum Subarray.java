public class Solution {
    public int minSubArray(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int cur = A[0];
        int min = cur;
        
        for (int i = 1; i < A.length; i++) {
            cur = Math.min(cur + A[i], A[i]);
            min = Math.min(min, cur);
        }
        
        return min;
    }
}
