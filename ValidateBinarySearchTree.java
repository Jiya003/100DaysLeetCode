/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    public boolean isValidBST(TreeNode root) {
        //O(n),O(n)
        List<Integer> ls=new ArrayList<>();

        InOrderTraversal(root,ls);

        for(int i=1;i<ls.size();i++){
            if(ls.get(i)<=ls.get(i-1)){
                return false;
            }
        }
        return true;
        
    }
    public void InOrderTraversal(TreeNode root, List<Integer> ls){
        if(root==null) return;

        InOrderTraversal(root.left,ls);
        ls.add(root.val);
        InOrderTraversal(root.right,ls);
    }
    */
    TreeNode prev=null;
    boolean ans=true;
    public boolean isValidBST(TreeNode root){       

        checkBST(root);
        return ans;
        
    }

    public void checkBST(TreeNode root){//, TreeNode prev,boolean ans){
        if(root==null) return;
        checkBST(root.left);
        if(prev!=null && prev.val>=root.val){
            ans=false;
            return;
        }

        prev=root;
        checkBST(root.right);
    }

}
