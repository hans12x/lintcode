/*891. Valid Palindrome II
中文English
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example
Example 1:

Input: s = "aba"
Output: true
Explanation: Originally a palindrome.
Example 2:

Input: s = "abca"
Output: true
Explanation: Delete 'b' or 'c'.
Example 3:

Input: s = "abc"
Output: false
Explanation: Deleting any letter can not make it a palindrome.
Notice
1.The string will only contain lowercase characters.
2.The maximum length of the string is 50000.
*/
public class Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            left++;
            right--;
        }
        if (left >= right){
            return true;
        } 
        return isSubPalindrome(s, left+1, right) || isSubPalindrome(s, left, right-1) ;
    }
    private boolean isSubPalindrome(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }    
            left++;
            right--;
        }
        return true;
    }
}

//caabggaac
