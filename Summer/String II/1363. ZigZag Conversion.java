/*1363. ZigZag Conversion
中文English
Given a string s and an integer numRows. You need to place s like zigzag. Then read the 'zigzag' line by line. Return the string you read.

Notice that zigzag extends according to the directions of down->up-right->down->up-right...

|   /|   /|
|  / |  / | ...
| /  | /  | ...
|/   |/   |/
Example
Example 1:

Input: "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Explanation: 
    After conversion, we get
    P   A   H   N
    A P L S I I G
    Y   I   R
    Read line by line, the answer is "PAHNAPLSIIGYIR".
Example 2:

Input: "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation: 
    After conversion, we get
    P     I     N
    A   L S   I G
    Y A   H R
    P     I
    Read line by line, the answer is "PINALSIGYAHRPI".
Example 3:

Input: "PAYPALISHIRING", numRows = 1
Output: "PAYPALISHIRING"
Explanation: 
    After conversion, we get
    PAYPALISHIRING
    Read line by line, the answer is "PAYPALISHIRING".
*/
public class Solution {
    /**
     * @param s: the given string
     * @param numRows: the number of rows
     * @return: the string read line by line
     */
     

    public String convert(String s, int nRows) {
        int length = s.length();
        if (length <= nRows || nRows == 1) return s;
        char[] chars = new char[length];
        int step = 2 * (nRows - 1);
        int count = 0;
        for (int i = 0; i < nRows; i++){
    		int interval = step - 2 * i;
    		//check the logic later.
    		for (int j = i; j < length; j += step){
    		   	chars[count] = s.charAt(j);
    			count++;
    			if (interval < step && interval > 0 && j + interval < length && count <  length){
    				chars[count] = s.charAt(j + interval);
    				count++;
    			}
    		}
    	}
        return new String(chars);
    }
}
    /*this method cost too much memory.
    public String convert(String s, int numRows) {
        // Write your code here
        if (numRows == 1){
            return s;
        } 
        char[] chars = s.toCharArray();
        char[][] matrix = new char[s.length()][numRows];
        int count = 0;
        int countX = 0;
        int countY = 0;
        int countUp =0;
        while(count < s.length() && count < s.length()){
            matrix[countX][countY] = chars[count];
            countY++;
            count++;
            if (countY == numRows-1){
                while(countUp<numRows && countY>0 && count < s.length()) {
                    matrix[countX][countY] = chars[count];
                    countUp++;
                    countX++;
                    countY--;
                    count++;
                    if(countUp==numRows){
                        countUp = 0;
                    }
                }
            }
        }
        String str = "";
        String tempStr = null;
        for (int j = 0;j<matrix[0].length ;j++ ){
            for (int i = 0;i < matrix.length ;i++ ){
                tempStr = String.valueOf(matrix[i][j]).trim();
                str = str + tempStr;
            } 
        } 
        return str;
    }
    */
