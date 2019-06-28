/*463. Sort Integers
中文English
Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.

Example
Example 1:
	Input:  [3, 2, 1, 4, 5]
	Output: [1, 2, 3, 4, 5]
	
	Explanation: 
	return the sorted array.

Example 2:
	Input:  [1, 1, 2, 1, 1]
	Output: [1, 1, 1, 1, 2]
	
	Explanation: 
	return the sorted array.
*/
public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
	//bubble sort
        if(A == null || A.length <=1){
            return;
        }
        for (int i = 0;i<A.length ;i++ ){
            for (int j = i+1; j<A.length ;j++ ){
                int temp = A[i];
                if(A[i]>=A[j]){
                    A[i]=A[j];
                    A[j]=temp;
                }
            } 
        }
    }
    public void sortIntegers(int[] A) {
	//Insertion sort
        if(A == null || A.length <=1){
            return;
        }
        for (int i = 0;i<A.length-1 ;i++ ){
            int temp = A[i];
            int j = i-1;
            for ( ;j>=0 ;j-- ){
                if (A[j]>temp){
                    A[j+1]= A[j];
                    
                } else{
                    break;
                }
            }
            a[j+1] = temp;
        } 
}