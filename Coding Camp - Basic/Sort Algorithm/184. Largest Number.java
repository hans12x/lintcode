/*184. Largest Number
中文English
Given a list of non negative integers, arrange them such that they form the largest number.

Example
Example 1:

Input:[1, 20, 23, 4, 8]
Output:"8423201"
Example 2:

Input:[4, 6, 65]
Output:"6654"
Challenge
Do it in O(nlogn) time complexity.

Notice
The result may be very large, so you need to return a string instead of an integer.
*/
public class Solution {
    /**
     * @param nums: A list of non negative integers
     * @return: A string
     */
    class NumbersComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            //considering the order for situation like [8,84]->[884/848]or[8,89]->[889/898]
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    public String largestNumber(int[] nums) {
        String[] strs = new String [nums.length];
        for (int i = 0;i<nums.length ;i++ ){
            strs[i] = Integer.toString(nums[i]);
        } 
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<strs.length ;i++ ){
            sb.append(strs[i]);
        }
        String result = sb.toString();
        if (result.charAt(0)=='0') {
            return "0";
        }
        return result;
    }
}