/*1195. Find Largest Value in Each Tree Row
中文English
You need to find the largest value in each row of a binary tree.

Example
Example 1:

Input:
{1,3,2,5,3,#,9}
Output:
[1,3,9]

Explanation:
     1
   /    \
  3     2
 /   \     \
5    3      9
Example 2:

Input:
{1,2,3,4,5,6,#,#,7}
Output:
[1,3,6,7]

Explanation:
           1
        /     \
     2         3
   /  \      /
 4    5   6
  \
   7
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
     * @param root: a root of integer
     * @return: return a list of integer
     */
    /*BFS
    public List<Integer> largestValues(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue <TreeNode> queue = new LinkedList<>();

        
        queue.offer(root);
        list.add(root.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            int maxVal = -1;
            for (int i = 0; i < size ;i++ ){
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.offer(temp.left);
                    maxVal = Math.max(temp.left.val,maxVal);
                } 
                if (temp.right != null){
                    queue.offer(temp.right);
                    maxVal = Math.max(temp.right.val,maxVal);
                }

                
            }
            if (maxVal>0){ 
                list.add(maxVal);
            }
        }
        return list;
    }
    */
    //DFS
    public List<Integer> largestValues(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    private void helper (TreeNode root, int depth, List<Integer> res){
        if (root == null){
            return;
        } 
        if (res.size() == depth ){
            res.add(root.val);
        }else {
            res.set(depth,Math.max(root.val,res.get(depth)));
        }
        
        helper(root.left, depth+1,res);
        helper(root.right, depth+1,res);
    }
}