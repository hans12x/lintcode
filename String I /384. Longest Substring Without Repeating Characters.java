/*384. Longest Substring Without Repeating Characters
中文English
Given a string, find the length of the longest substring without repeating characters.

Example
Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The longest substring is "abc".
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The longest substring is "b".
Challenge
time complexity O(n)
*/
public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        //use two pointers, map
        if(s== null || s.length()==0 ){
            return 0;
        }
        // 256 is the number of ascii characters
        //map only record [0,1] to see whether the char is exist in S
        int[] map = new int [256];
        int i = 0;
        int j = 0;
        int maxL = 0;
        for (i = 0;i< s.length() ;i++ ){
            while(j < s.length() && map[s.charAt(j)]==0){
                // if S doesn't contain this char before
                map[s.charAt(j)] = 1;
                //record the max length of substring
                maxL = Math.max(maxL,j-i+1);
                //right pointer++
                j++;
            }
            // when while loop end, it means whether it goes to the end or there's repeat
            // char, if there's repeat char, reset its value to 0, then left pointer can go forward
            map[s.charAt(i)] = 0;    
        } 
       
        return maxL;
    }
}