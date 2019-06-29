/*1375. Substring With At Least K Distinct Characters
中文English
Given a string S with only lowercase characters.

Return the number of substrings that contains at least k distinct characters.

Example
Example 1:

Input: S = "abcabcabca", k = 4
Output: 0
Explanation: There are only three distinct characters in the string.
Example 2:

Input: S = "abcabcabcabc", k = 3
Output: 55
Explanation: Any substring whose length is not smaller than 3 contains a, b, c.
    For example, there are 10 substrings whose length are 3, "abc", "bca", "cab" ... "abc"
    There are 9 substrings whose length are 4, "abca", "bcab", "cabc" ... "cabc"
    ...
    There is 1 substring whose length is 12, "abcabcabcabc"
    So the answer is 1 + 2 + ... + 10 = 55.
Notice
10 ≤ length(S) ≤ 1,000,000
1 ≤ k ≤ 26
*/
public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        int[] cnt = new int[26];
        int count = 0;
        int left = 0, right = 0;
        int len = s.length();
        long ans = 0;
        while (left <= right && left<len){
            while (count < k && right < len){//move right pointer to gain more char till k.
                int now = s.charAt(right) - 'a';
                cnt[now]++;
                if(cnt[now] == 1){//new char appears.
                    count++;
                }
                right++;
            }
            if (count == k){
                ans += len - right + 1;
            } 
            int now = s.charAt(left) - 'a';
            if (cnt[now] == 1){
                count--;
            } 
            cnt[now]--;
            left++;
        }
        return ans;
    }
}