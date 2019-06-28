/* 415. Valid Palindrome
中文English
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example
Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama"
Example 2:

Input: "race a car"
Output: false
Explanation: "raceacar"
Challenge
O(n) time without extra memory.

Notice
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
	//use two pointers start moving from two sides of the string and compare with each 	//other. 
        if(s.length() == 0 || s == null){
            return true;
        }
        char[] list = s.toLowerCase().toCharArray();
        int front = 0, end = list.length-1;
        while(front < end){
	    // skip the blank or special symbol
            while(front < end && Character.isLetterOrDigit(list[front]) == false){
                front++;
            }
		
            if(front == list.length){//there's no letters or numbers 
                return true;
            }
            while(front< end && Character.isLetterOrDigit(list[end]) == false){
                end--;
            }
	    //compare front and end 
            if(list[front]!=list[end]){
                return false;
            }
            front++;
            end--;
        }
        return true;
    }
}
