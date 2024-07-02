/*
Question No. 337
House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 

Example 1:

Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    0 <= Node.val <= 104


*/

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
    public int rob(TreeNode root) {
        if(root==null) return 0;
        int options[]=new int[2];
        options=f(root);
        return Math.max(options[0],options[1]);
        
    }

    public int[] f(TreeNode root){
        int options[]=new int[2];
        //Arrays.fill(options,0);
        if(root==null) return new int[2];//options;

        int[] leftTree=f(root.left);
        int[] rightTree=f(root.right);

        options[0]=(root.val+leftTree[1]+rightTree[1]);
        options[1]=Math.max(leftTree[0],leftTree[1])+Math.max(rightTree[0],rightTree[1]);

        return options;

    }
}
