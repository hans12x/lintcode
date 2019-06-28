/*53. Reverse Words in a String
中文English
Given an input string, reverse the string word by word.

Example
Example 1:
	Input:  "the sky is blue"
	Output:  "blue is sky the"
	
	Explanation: 
	return a reverse the string word by word.

Example 2:
	Input:  "hello world"
	Output:  "world hello"
	
	Explanation: 
	return a reverse the string word by word.

Clarification
What constitutes a word?
A sequence of non-space characters constitutes a word and some words have punctuation at the end.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/
public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        if(s.length() ==0 || s == null){
            return "";
        }
        String[] list = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = list.length-1 ;i >=0 ;i-- ){
            System.out.println(list[i]);
            if(!list[i].equals("")){
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(list[i]);
            }
        } 
        return sb.toString();
    }
    
}
    