public class Solution {
    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        StringBuilder result = new StringBuilder();
        Stack<Integer> counts = new Stack<Integer>();
        Stack<StringBuilder> strs = new Stack<StringBuilder>();
        
        int i = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (c == '[') {
                strs.push(new StringBuilder());
                i++;
            } else if (c == ']') {
                int count = counts.pop();
                StringBuilder str = strs.pop();

                for (int j = 0; j < count; j++) {
                    if (strs.empty()) {
                        result.append(str);
                    } else {
                        strs.peek().append(str);
                    }
                }
                
                i++;
            } else if (Character.isDigit(c)) {
                int start = i++;
                
                while (Character.isDigit(s.charAt(i)) && i < s.length()) {
                    i++;
                }
                
                counts.push(Integer.parseInt(s.substring(start, i)));
            } else {
                if (strs.empty()) {
                    result.append(c);
                } else {
                    strs.peek().append(c);
                }
                
                i++;
            }
        }
        
        return result.toString();
    }
}

public class Solution {
    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                int start = i++;
                
                while (Character.isDigit(s.charAt(i)) && i < s.length()) {
                    i++;
                }
                
                int count = Integer.parseInt(s.substring(start, i));
                int left = 1;
                start = ++i;
                
                while (i < s.length()) {
                    if (s.charAt(i) == '[') {
                        left++;
                    } else if (s.charAt(i) == ']') {
                        left--;
                        
                        if (left == 0) {
                            break;
                        }
                    }
                    
                    i++;
                }

                String str = decodeString(s.substring(start, i));
                
                for (int j = 0; j < count; j++) {
                    result.append(str);
                }
                
                i++;
            } else {
                result.append(c);
                i++;
            }
        }
        
        return result.toString();
    }
}