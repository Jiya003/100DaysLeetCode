/*
Question 938: Range Sum of BST
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].


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
 import java.util.*;
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        int sum=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            if(current.val>=low && current.val<=high){
                sum+=current.val;
            }
            
            if(current.left!=null){
                queue.offer(current.left);
            }

            if(current.right!=null){
                queue.offer(current.right);
            }
        }
        return sum;        
    }
}
