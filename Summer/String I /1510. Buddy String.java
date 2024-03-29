/*1510. Buddy Strings
Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

Example
Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
Notice
1.0 <= A.length <= 20000
2.0 <= A.length <= 20000
3.A and B consist only of lowercase letters.
*/

public class Solution {
    /**
     * @param A: string A
     * @param B: string B
     * @return: bool
     */
    public boolean buddyStrings(String A, String B) {
       if(A.length() != B.length()){
           return false;
       }
       if(A.equals(B)){
           Set<Character> s = new HashSet<>();
           for(char c : A.toCharArray()){
               s.add(c);
           }
           return s.size()<A.length();
       }
       List<Integer>diff = new ArrayList<>();
       for (int i = 0;i<A.length() ;i++ ){
           if(A.charAt(i) != B.charAt(i)){
               diff.add(i);
           }
       }
       return diff.size() == 2 && A.charAt(diff.get(0))==B.charAt(diff.get(1))&& A.charAt(diff.get(1))==B.charAt(diff.get(0));
    }
}