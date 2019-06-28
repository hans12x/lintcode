/* 173. Insertion Sort List
中文English
Sort a linked list using insertion sort.

Example
Example 1:
	Input: 0->null
	Output: 0->null


Example 2:
	Input:  1->3->2->0->null
	Output :0->1->2->3->null
*/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        if (head == null || head.next == null){
            return head;
        } 
        ListNode pre = dummy;
		ListNode cur = head;


        while (cur!= null){
            pre = dummy;
            //start from the next node of fake head(dummy)
            // make pre be the max node that smaller than cur.val
            while (pre.next != null && pre.next.val < cur.val) {
                 pre = pre.next;
            }
            
            //next is the temp node that = cur.next
            ListNode next = cur.next;
            //make it : pre->cur->pre.next
            //cur.next points to pre.next
            cur.next = pre.next;
            pre.next = cur;
            cur = next; 

        }
        return dummy.next;
    }
}