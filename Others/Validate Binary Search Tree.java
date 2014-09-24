/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        TreeNode[] pre = new TreeNode[1];
        
        return helper(root, pre);
    }
    
    private boolean helper(TreeNode root, TreeNode[] pre) {
        if (root == null) {
            return true;
        }
        
        if (!helper(root.left, pre)) {
            return false;
        }
        
        if (pre[0] != null && root.val <= pre[0].val) {
            return false;
        }
        pre[0] = root;
        
        if (!helper(root.right, pre)) {
            return false;
        }
        
        return true;
    }
}