/*1172. Binary Tree Tilt
中文English
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example
Example 1:

Input: 
{1,2,3}
Output: 1

Explanation: 
         1
       /   \
      2     3
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
**Example 2: **

Input：
{1,1,#,2,3}
Output：
7

Explanation：
        1
      /
    1
   /  \
2     3
Notice
1.The sum of node values in any subtree won't exceed the range of 32-bit integer.
2.All the tilt values won't exceed the range of 32-bit integer.
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
     * @param root: the root
     * @return: the tilt of the whole tree
     */
    private int[] cnt = new int[2];
    public int findTilt(TreeNode root){
        helper(root);
        return cnt[0];
    }
    private int helper(TreeNode root) {
        // Write your code here
        if (root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        
        cnt[0] += Math.abs(left-right);
        return root.val + left + right;
    }
  
}

