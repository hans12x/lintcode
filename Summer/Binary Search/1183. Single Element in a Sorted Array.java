/* 1183. Single Element in a Sorted Array
中文English
Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
Example
Your solution should run in O(log n) time and O(1) space.
*/
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a integer
     */
    /*bit operation
    public int singleNonDuplicate(int[] nums) {
        // write your code here
        int res = 0;
        for (int i = 0;i<nums.length ;i++ ){
            //for any x, x^x = 0, x^0 = x
            res ^= nums[i];
        } 
        return res;
    }
    */
    
    //binary search
    //before target, every value at even index is equal to the value after it
    //after target, every value at even index is equal to the value before it 
    public int singleNonDuplicate(int[] nums) {
        // write your code here
        int start = 0, end = nums.length-1;
        while (start+1<end){
            int mid = start + (end-start)/2;
            if (mid % 2 == 1){
                mid--;
            }
            if (nums[mid] == nums[mid+1]){
                start = mid + 2;
            }
            else {
                end = mid;
            }
                
            
        }
        return nums[start + (end-start)/2];
    }
}