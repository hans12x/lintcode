/*386. Longest Substring with At Most K Distinct Characters
中文English
Given a string S, find the length of the longest substring T that contains at most k distinct characters.

Example
Example 1:

Input: S = "eceba" and k = 3
Output: 4
Explanation: T = "eceb"
Example 2:

Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"
Challenge
O(n) time
*/
public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        //use two pointers
        int[]dict = new int[256];
        int left = 0, right = 0;
        int maxL = 0;
        int sum = 0;
        for (;right<s.length() ;right++ ){
            dict[s.charAt(right)]++;
            if (dict[s.charAt(right)] == 1){
                sum++;
            }
            while(sum > k){
                dict[s.charAt(left)]--;
                if (dict[s.charAt(left)]==0){
                    sum--;
                } 
                left++;
            } 
            maxL = Math.max(right-left+1,maxL);
        } 
        return maxL;
    }
}