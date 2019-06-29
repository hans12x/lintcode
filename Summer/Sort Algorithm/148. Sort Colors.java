/*148. Sort Colors
中文English
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Notice
You are not suppose to use the library's sort function for this problem.
You should do it in-place (sort numbers in the original array).
*/
public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return;
        }
        /*version1
        int[] cnt = new int[3];
        for (int i = 0;i<nums.length ;i++ ){
            cnt[nums[i]]++;
            System.out.println(nums[i]+","+cnt[nums[i]]);
        }
        for (int i = 0;i<nums.length ;i++ ){
            if(i<cnt[0]){
                nums[i]=0;
            }else if(i<cnt[0]+cnt[1]){
                nums[i]=1;
            }else{
                nums[i]=2;
            }
        }  
        */
        //version2
        //all int before left is 0, after right is 2.
        int left = 0, right = nums.length-1, pos = 0;
        while(pos<=right){
            if (nums[pos]==0){
                swap(nums, left, pos);
                left++;
                pos++;
            }else if (nums[pos]==1){
                pos++;
            }else{
                swap(nums,right,pos);
                right--;
            }
        }
       
    }
     private void swap (int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
}