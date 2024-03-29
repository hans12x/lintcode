/*585. Maximum Number in Mountain Sequence
中文English
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Example
Example 1:

Input: nums = [1, 2, 4, 8, 6, 3] 
Output: 8
Example 2:

Input: nums = [10, 9, 8, 7], 
Output: 10
*/
public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length ==0 ){
            return 0;
        }

        int start = 0, end = nums.length-1;
        
        while(start+1<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }else{
                start=mid;
            }
        }
        
        return Math.max(nums[start],nums[end]);
        
    }
}