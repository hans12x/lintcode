/*1219. Heaters
中文English
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Example
Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
Notice
1.Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
2.Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
3.As long as a house is in the heaters' warm radius range, it can be warmed.
4.All the heaters follow your radius standard and the warm radius will the same.
*/
public class Solution {
    /**
     * @param houses: positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int start = 0, end =1000000000;
        int mid = start + (end - start)/2;
        while(start < end){
            //check whether mid is the range that can cover all houses
            if (check(mid,houses,heaters)){
                end = mid;
            }else {
                start = mid + 1;
            }
            mid = start + (end - start)/2;
        }
        return mid;
    }
    private boolean check(int mid, int[] houses, int[] heaters){
        //use two pointers
        int index = 0;//the pointer for heaters
        
        for (int i = 0;i<houses.length ;i++ ){
            while (index < heaters.length && Math.abs(heaters[index] - houses[i]) > mid){
                index ++ ;
               
            }
             if (index == heaters.length || Math.abs(heaters[index] - houses[i]) > mid ) {
                    return false;
                }
        }
        return true;
    }
}