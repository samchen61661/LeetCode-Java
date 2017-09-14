/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        } else {
            NestedInteger ni = new NestedInteger();
            int i = 1;
            int start = 1;

            while (i < s.length()) {
                char ch = s.charAt(i);
                
                if (ch == '[') {
                    int left = 1;

                    while (left > 0) {
                        if (s.charAt(i + 1) == '[') {
                            left++;
                        } else if (s.charAt(i + 1) == ']') {
                            left--;
                        }
                        
                        i++;
                    }
                } else if (ch == ',' || ch == ']') {
                    if (i > start) {
                        ni.add(deserialize(s.substring(start, i)));
                    }
                    
                    start = i + 1;
                }
                
                i++;
            }
            
            return ni;
        }
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        NestedInteger result = new NestedInteger();
        stack.push(result);
        int start = 1;
        
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '[') {
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = i + 1;
            } else if (ch == ',' || ch == ']') {
                if (i - start > 0) {
                    NestedInteger ni = new NestedInteger(Integer.parseInt(s.substring(start, i)));
                    stack.peek().add(ni);
                }
                
                start = i + 1;
                
                if (ch == ']') {
                    stack.pop();
                }
            }
        }
        
        return result;
    }
}
