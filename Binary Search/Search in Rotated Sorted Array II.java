public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = A.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (A[mid] == target) {
                return true;
            }
            else if (A[low] < A[mid]) {
                if (A[low] <= target && target < A[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (A[low] > A[mid]) {
                if (A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                low++;
            }
        }
        
        return false;
    }
}