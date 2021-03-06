public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] rec = new int[256];
        int start = 0;
        int end = 0;
        
        while (end < s.length()) {
            int ch = s.charAt(end++);
            rec[ch]++;
            
            while (rec[ch] > 1) {
                rec[s.charAt(start++)]--;
            }
            
            result = Math.max(result, end - start);
        }
        
        return result;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] rec = new int[256];
        int start = 0;
        int end = 0;
        int count = 0;
        
        while (end < s.length()) {
            if (rec[s.charAt(end++)]++ > 0) {
                count++;
            }
            
            while (count > 0) {
                if (rec[s.charAt(start++)]-- > 1) {
                    count--;
                }
            }
            
            result = Math.max(result, end - start);
        }
        
        return result;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] index = new int[256];
        int start = 0;
        int end = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            start = Math.max(index[c], start);
            result = Math.max(result, end - start + 1);
            index[c] = ++end;
        }
        
        return result;
    }
}
