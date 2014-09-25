/*
* Author: Fan Gu
* Email: ava.gu1990@gmail.com
* Credits: Tianxiang Zhang
*/

/*
* Problem:
* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
*/


public class Solution {
   public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       if(root == null)
           return res;
       else{
           ArrayList<Integer> path = new ArrayList<Integer>();
           hasPathSum(res, root, path, sum);
           return res;
       }
   }
   public void hasPathSum(ArrayList<ArrayList<Integer>> res, TreeNode root, ArrayList<Integer> path, int remain){
       if(root == null)
           return;
       if(root.val == remain && root.left == null && root.right == null){
           path.add(root.val);
           ArrayList<Integer> newpath = new ArrayList<Integer>(path);
           res.add(newpath);
           path.remove(path.size() - 1);
           return;
       }
       else{
            int r = remain - root.val;
            path.add(root.val);
            hasPathSum(res, root.left, path, r);
            hasPathSum(res, root.right, path, r);
            path.remove(path.size() - 1);
       }
   }
}
