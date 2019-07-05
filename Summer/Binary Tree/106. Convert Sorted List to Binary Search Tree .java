/*106. Convert Sorted List to Binary Search Tree
中文English
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Example
Example 1:
	Input: array = [1,2,3]
	Output:
		 2  
		/ \
		1  3
		
Example 2:
	Input: [2,3,6,7]
	Output:
		 3
		/ \
	       2   6
		     \
		      7

	Explanation:
	There may be multi answers, and you could return any of them.
null
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        ListNode curt = head;
        while (curt != null){
            list.add(curt.val);
            curt = curt.next;
        }
        return buildTree(list, 0, list.size()-1);
    }
    private TreeNode buildTree(List<Integer> list,int start, int end){
        if (start>end){
            return null;
        } 
        if (start == end){
            return new TreeNode(list.get(start));
        } 
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list,start,mid-1);
        root.right = buildTree(list,mid+1,end);
        return root;
        
    }
   
}