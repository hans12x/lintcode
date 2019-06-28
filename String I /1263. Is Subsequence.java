/*1263. Is Subsequence
中文English
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (length <= 100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example
Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = `"axc"`, t = `"ahbgdc"`
Output: false
Challenge
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
*/


public class Solution {
    /**
     * @param s: the given string s
     * @param t: the given string t
     * @return: check if s is subsequence of t
     */
    public boolean isSubsequence(String s, String t) {
        // the point is use iteration to count how many chars in s is in t(this way
        // can also ensure that the chars are in order)
        char[] sList = s.toCharArray();
        int index = 0;
        for (int i = 0;i<t.length() ;i++ ){
            if(index<sList.length && sList[index]== t.charAt(i)){
                index++;
            }
        } 
        if(index == sList.length){
            return true;
        }
        return false;
    }
}