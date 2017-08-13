public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0;
        int high = len - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (len - mid <= citations[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return len - low;
    }
}

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int i = 0;
        
        while ((i + 1) <= len && citations[len - i - 1] >= i + 1) {
            i++;
        }
        
        return i;
    }
}
