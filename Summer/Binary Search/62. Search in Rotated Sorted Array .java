/*62. Search in Rotated Sorted Array
中文English
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Example
Example 1:

Input: [4, 5, 1, 2, 3] and target=1, 
Output: 2.
Example 2:

Input: [4, 5, 1, 2, 3] and target=0, 
Output: -1.
Challenge
O(logN) time
*/
public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length ==0 ){
            return -1;
        }
        int start = 0;
        int end = A.length-1;
        int pivot = A.length-1;
        while(start+1<end){
            int mid = start + (end - start)/2;
            if(A[mid] < A[pivot]){
                end = mid;  
            }else {
                start = mid;
            }
        }
        int index = A[start]<A[end]? start:end;
        if(target == A[pivot]){
            return pivot;
        }
        else {
            if(target<A[pivot]){
                start = index;
                end = A.length-1;
            }
            else {
                start = 0;
                end = index-1;
            }
               
                while(start+1<end){
                     int mid = start + (end - start)/2;
                    if(target == A[mid]){
                        start = mid;
                    }
                    else if(A[mid] < target){
                        start = mid;  
                    }else {
                        end = mid;
                    }
                }
            if (A[start] == target){
                return start;
            }
            if (A[end] == target){
                return end;
            }
        }    
            
        return -1;  
        
    }
}
