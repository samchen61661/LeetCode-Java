public class Solution {
    public String alienOrder(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
        
        HashMap<Character, HashSet<Character>> rec = new HashMap<Character, HashSet<Character>>();
        String pre = null;
        
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            
            for (int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                
                if (!rec.containsKey(c)) {
                    rec.put(c, new HashSet<Character>());
                }
            }
            
            if (pre != null) {
                for (int j = 0; j < pre.length() && j < cur.length(); j++) {
                    char x = pre.charAt(j);
                    char y = cur.charAt(j);
                    
                    if (x == y) {
                        continue;
                    } else {
                        rec.get(x).add(y);
                        break;
                    }
                }
            }
            
            pre = cur;
        }
        
        StringBuilder sb = new StringBuilder();

        for (Character key : rec.keySet()) {
            if (!helper(rec, key, new HashSet<Character>(), sb)) {
                return "";
            }
        }
        
        sb.reverse();
        
        return sb.toString();
    }
    
    private boolean helper(HashMap<Character, HashSet<Character>> rec, char key, HashSet<Character> path, StringBuilder sb) {
        if (path.contains(key)) {
            return false;
        }
        
        if (sb.indexOf(Character.toString(key)) != -1) {
            return true;
        }
 
        path.add(key);
        
        for (Character val : rec.get(key)) {
            if (!helper(rec, val, path, sb)) {
                return false;
            }
        }
        
        path.remove(key);
        sb.append(key);
        
        return true;
    }
}