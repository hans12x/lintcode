/*1282. Reverse Vowels of a String
中文English
Write a function that takes a string as input and reverse only the vowels of a string.

Example
Example 1:

Input : s = "hello"
Output :  "holle"
Example 2:

Input : s = "lintcode"
Output : "lentcodi".
Notice
The vowels does not include the letter "y".
*/
public class Solution {
    /**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        // write your code here
        if (s == null || s.length() == 0){
            return s;
        }
        
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0, end = s.length()-1;
        
        while (start < end){
            while(start < end && !vowels.contains(chars[start]+"")){
                start++;
            }
            while(start < end && !vowels.contains(chars[end]+"")){
                end--;
            }
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            
            start++;
            end--;
        }
        return new String(chars);
        
    }
}