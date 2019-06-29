/*464. Sort Integers II
中文English
Given an integer array, sort it in ascending order in place. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.

Example
Example1:

Input: [3, 2, 1, 4, 5], 
Output: [1, 2, 3, 4, 5].
Example2:

Input: [2, 3, 1], 
Output: [1, 2, 3].
*/
public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        //better use merge sort, because quick sort is not steady enough, it may be O(n2)
        //if the chosen pivot is the smallest or biggest
        //merge_sort(A, new int[A.length], 0,A.length-1);
        quick_sort(A,0,A.length-1);
    }
    
    private void quick_sort(int[] A, int start, int end ){
        if (start >= end){
            return;
        } 
        int left = start, right = end;
        int mid = start + (end - start)/2;
        //key point: pivot is value not index
        int pivot = A[mid];
        
        //key point: it should always be left<=right not <.
        while(left <= right){
            while (left<=right && A[left]<pivot){
                left++;
            }
            while (left<=right && A[right]>pivot){
                right--;
            }
            if (left <= right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left++;
                right--;
            } 
            
        }
        quick_sort(A, start, right);
        quick_sort(A, left, end);
        
    }
    
    private void merge_sort(int[] A, int[] temp, int start, int end){
        if (start >= end){
            return;
        }
        
        //divide
        int mid = start+(end-start)/2;
        merge_sort(A, temp,  start, mid);
        merge_sort(A, temp, mid+1, end);
        
        //merge
        int index = start;
        int leftStart = start;
        int rightStart = mid+1;
        
        //iterate each value in left & right part and put the value into the temp[] in 		//right order
        while (leftStart <= mid && rightStart <= end){
            if (A[leftStart] <= A[rightStart]){
                temp [index++] = A[leftStart++];
            }
            else {
                temp [index++] = A[rightStart++];
            }
        }
        
        
        // if the length of left & right parts are different, add the remaining values 		//into temp[] 
        while (leftStart <= mid){
            temp [index++] = A[leftStart++];
        }
        while (rightStart <= end){
            temp [index++] = A[rightStart++];
        }
        
        //copy temp[] to A[]
        for (int i=start;i<=end ;i++ ){
            A[i] = temp[i];
        } 
    }
}
