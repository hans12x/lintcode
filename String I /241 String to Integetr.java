/*241. String to Integer
Given a string, convert it to an integer. You may assume the string is a valid integer number that can be presented by a signed 32bit integer (-231 ~ 231-1).

Example
Example 1:
	Input:  "123"
	Output: 123
	
	Explanation: 
	return the Integer.

Example 2:
	Input:  "2"
	Output: 2
	
	Explanation: 
	return the Integer.
*/

 public class Solution {
    /**
     * @param str: A string
     * @return: An integer
     */
    public int stringToInteger(String str) {
        int res = 0;
        boolean negative = false;
        for (int i = 0 ;i < str.length() ;i++ ){
            if(str.charAt(i)=='-'){
                negative = true;
                continue;
            }
            res *= 10;
            res += (str.charAt(i)-'0');
            
        } 
        
        return negative == false ? res: -res;
    }
}