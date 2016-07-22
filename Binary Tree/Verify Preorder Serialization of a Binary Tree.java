public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        int degree = 1;
        String[] nodes = preorder.split(",");
        
        for (String node : nodes) {
            if (--degree < 0) {
                return false;
            }
            
            if (!node.equals("#")) {
                degree += 2;
            }
        }
        
        return degree == 0;
    }
}