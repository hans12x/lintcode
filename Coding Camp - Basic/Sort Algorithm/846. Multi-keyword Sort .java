/*846. Multi-keyword Sort
中文English
Given n students and their test scores, expressed as (student number, test scores), sort by test scores in descending order, if the test scores are the same, sort the student number in ascending order.

Example
Example1

Input: array = [[2,50],[1,50],[3,100]]
Output: [[3,100],[1,50],[2,50]]
Example2

Input: array = [[2,50],[1,50],[3,50]]
Output: [[1,50],[2,50],[3,50]]
*/
public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public int[][] multiSort(int[][] array) {
        for (int i = 0;i<array.length;i++ ){
            for (int j = i+1;j<array.length ;j++ ){
                if (!cmp(array[i],array[j])){
                    int tmp = array[i][0];
                    array[i][0] = array[j][0];
                    array[j][0] = tmp;
                    
                    tmp = array[i][1];
                    array[i][1]=array[j][1];
                    array[j][1]=tmp;
                } 
            } 
        }
        return array;
    }
    
    private boolean cmp(int[]a, int[] b){
        if(a[1]>b[1]){
            return true;
        }
        if (a[1]==b[1] && a[0]<b[0]){
            return true;
        } 
        return false;
    }
}