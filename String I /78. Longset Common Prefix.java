/*78. Longest Common Prefix
中文English
Given k strings, find the longest common prefix (LCP).

Example
Example 1:
	Input:  "ABCD", "ABEF", "ACEF"
	Output:  "A"
	

Example 2:
	Input: "ABCDEFG", "ABCEFG" and "ABCEFA"
	Output:  "ABC"
*/
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        //compare all strings' first n chars together
        
        if (strs.length==0 || strs == null){
            return "";
        }
        char[] result = new char[strs[0].length()];
        for (int i = 0; i<strs[0].length(); i++){//for every char in strs[0]
            
            boolean temp = true;
            for (int j = 1; j<strs.length; ++j){//go through all other strs
                if(strs[j].length()<1){
                    return "";
                }
                else if(strs[j].length()<=i||strs[j].charAt(i)!=strs[0].charAt(i)){
                    temp = false;
                    break;
                }
            }
            if (temp == true){
               result[i] = strs[0].charAt(i) ;
            }
            
        }
        
        return String.valueOf(result).trim();
        
    }
}