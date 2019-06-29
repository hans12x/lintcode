/*1191. Longest Uncommon Subsequence II
中文English
Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example
Example 1:

Input:
["aaa","acb"]
Output:
3
Example 2:

Input:
["aabbcc", "aabbcc","cb"]
Output:
2
Notice
All the given strings' lengths will not exceed 10.
The length of the given list will be in the range of [2, 50].
*/
public class Solution {
    /**
     * @param strs: List[str]
     * @return: return an integer
     */
    class strLengthSort implements Comparator<String>{
        public int compare(String s1,String s2){
            //put the str with longer length in front.
            return -(s1.length()-s2.length());
        }
    }
    public int findLUSlength(String[] strs) {
        // write your code here
        //ex. ["aaab","axb","aaa","aa","a"], output = 3
        //ex. ["aaab","aab","aaa","aa","a"], output = 4
        //sort strs based on the length of each str.
        Arrays.sort(strs, new strLengthSort());
        
        for (int i = 0;i<strs.length ;i++ ){
            boolean flag = false;
            //review here.
            for(int j = 0; j < strs.length && strs[j].length() >= strs[i].length(); j++){
                if (j == i ){
                    continue;
                }
                if (whetherContains(strs[j],strs[i])){
                    flag = true;
                    break;
                } 
            }
            if (flag == false){
                return strs[i].length();
            } 
        }
        return -1;
    }
    
    private boolean whetherContains(String a, String b){
        int index = 0;
        for (int i = 0;i<a.length() ;i++ ){
            if (a.charAt(i) == b.charAt(index)){
                index++;
            }
            if (index == b.length()){
                return true;
            } 
        }
        return false;
    }
}

