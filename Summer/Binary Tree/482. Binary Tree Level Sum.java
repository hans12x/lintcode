/* 482. Binary Tree Level Sum
中文English
Given a binary tree and an integer which is the depth of the target level.

Calculate the sum of the nodes in the target level.

Example
Example 1:

Input：{1,2,3,4,5,6,7,#,#,8,#,#,#,#,9},2
Output：5 
Explanation：
     1
   /   \
  2     3
 / \   / \
4   5 6   7
   /       \
  8         9
2+3=5
Example 2:

Input：{1,2,3,4,5,6,7,#,#,8,#,#,#,#,9},3
Output：22
Explanation：
     1
   /   \
  2     3
 / \   / \
4   5 6   7
   /       \
  8         9
4+5+6+7=22
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    /*BFS
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null){
            return 0;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        int count = 1, sum = 0;
        queue.offer(root);
        while (!queue.isEmpty() && count < level){
            int size = queue.size();
            count++;
            for (int i = 0; i < size ;i++ ){
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.offer(temp.left);
                } 
                if (temp.right != null){
                    queue.offer(temp.right);
                } 
            } 
          
        }
        if (count == level){
                while(!queue.isEmpty()){
                    sum += queue.poll().val;
                }
            } 
        return sum;
    }
    */
    //DFS
    private int sum  = 0;
    public int levelSum(TreeNode root, int level){
        helper(root, 1, level);
        return sum;
    }
    private void helper(TreeNode root, int depth, int level){
        if (root == null){
            return;
        }
        if (depth == level){
            sum += root.val;
            return;
        } 
        helper(root.left, depth+1, level);
        helper(root.right, depth+1, level);
    }
    
}
