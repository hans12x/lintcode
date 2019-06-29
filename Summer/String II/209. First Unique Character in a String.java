/*209. First Unique Character in a String
中文English
Find the first unique character in a given string. You can assume that there is at least one unique character in the string.

Example
Example 1:
	Input: "abaccdeff"
	Output:  'b'
	
	Explanation:
	There is only one 'b' and it is the first one.


Example 2:
	Input: "aabccd"
	Output:  'b'
	
	Explanation:
	'b' is the first one.
*/
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        //don't use map because array only cost O(1).
        int[] cnt = new int[26];
        //record the location that each letter appears
        for (int i = 0;i<str.length() ;i++ ){
            //now represent it's letter index (count from 0)
            int now = str.charAt(i)-'a';
            if (cnt[now]==0){
                cnt[now]=i+1;
            }else if (cnt[now]>0){
                cnt[now]=-1;
            } 
        } 
        
        char ans = 'a';
        int tmp = Integer.MAX_VALUE;
        for (int i = 0;i<26 ;i++ ){
            if (cnt[i]>0){
                if (cnt[i]<tmp) {
                    tmp = cnt[i];
                    ans = (char)('a'+i);
                }
                
            } 
        } 
        return (char)ans;
    }
}