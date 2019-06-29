/*104. Merge K Sorted Lists
中文English
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Example
Example 1:
	Input:   [2->4->null,null,-1->null]
	Output:  -1->2->4->null

Example 2:
	Input: [2->6->null,5->null,7->null]
	Output:  2->5->6->7->null
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
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0){
            return null;
        }
        
        while (lists.size() > 1){
            List<ListNode> new_lists = new ArrayList<ListNode>();
            for (int i = 0;i < lists.size()-1 ;i+= 2 ){
		//every time merge two lists.
                ListNode merger_list = merge(lists.get(i),lists.get(i+1));
                new_lists.add(merger_list);
            }
            if(lists.size() % 2 == 1){
                new_lists.add(lists.get(lists.size()-1));
            }
            lists = new_lists;
        }
        
        return lists.get(0);
    }	
    //same as 165. Merge two Sorted lists.
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                lastNode.next = l1;
                l1 = l1.next;
            } 
            else{
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null){
            lastNode.next = l1;
        } 
        else{
            lastNode.next = l2;
        }
        return dummy.next;
    }
}
