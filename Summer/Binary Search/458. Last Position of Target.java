/*458. Last Position of Target
中文English
Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Example
Example 1:

Input: nums = [1,2,2,4,5,5], target = 2
Output: 2
Example 2:

Input: nums = [1,2,2,4,5,5], target = 6
Output: -1
*/
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;
        
        if(nums == null|| nums.length == 0){
            return -1;
        }
        while(min+1<max){
            int mid = min+ (max-min)/2;
            if (target == nums[mid]){//case 1,1,1,1 1.mid = 1,min = 1; 2.mid=2,min =2 ;min+1=max,loop end
                min = mid;
            }
            
            else if(nums[mid]<target) {
                min = mid;
                
            }
            else {
                max = mid;
            }
        }
        
        if(nums[max]==target){
            return max;
        } 
        
        if(nums[min]== target){
            return min;
        }
        
        return -1;
    }
}