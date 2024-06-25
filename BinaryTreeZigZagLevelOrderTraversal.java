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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls=new ArrayList<>();
        if(root==null){
            return ls;
        }        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        boolean flag=true;

        while(!queue.isEmpty()){
            List<Integer> l=new ArrayList<>();
            int len=queue.size();
            
            for(int i=0;i<len;i++){
                TreeNode curr=queue.poll();
                //l.add(curr.val);

                if(flag){
                    l.add(curr.val);
                }else{
                    l.add(0,curr.val);
                }

                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }               

            }            

            ls.add(l);
            flag=!flag;
        }

        return ls;

    }
}
