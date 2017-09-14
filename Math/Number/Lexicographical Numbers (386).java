class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        long curr = 1;
        result.add(1);
        
        for (int i = 2; i <= n; i++) {
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr += 1;
            } else {
                curr /= 10;
                
                while (curr % 10 == 9) {
                    curr /= 10;
                }
                
                curr++;
            }
            
            result.add((int) curr);
        }
        
        return result;
    }
}

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        dfs(1, n, result);
        
        return result;
    }
    
    private void dfs(long curr, int n, List<Integer> result) {
        if (curr > n) {
            return;
        }
        
        result.add((int) curr);
        dfs(curr * 10, n, result);
        
        if (curr % 10 != 9) {
            dfs(curr + 1, n, result);
        }
    }
}
