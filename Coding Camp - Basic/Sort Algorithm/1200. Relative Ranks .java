/*1200. Relative Ranks
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example

Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the right two athletes, you just need to output their relative ranks according to their scores.
Notice
N is a positive integer and won't exceed 10,000.
*/
public class Solution {
    /**
     * @param nums: List[int]
     */
    public String[] findRelativeRanks(int[] nums) {
        int[] ranks = new int[nums.length];
	//can't just use int [] ranks = nums, Arrays.sort() will change nums[] as well.
        for(int i = 0; i<nums.length; i++ ){
            ranks[i] = nums[i];
        }
        Arrays.sort(ranks);
        HashMap <Integer, String> map = new HashMap<>();
        for(int i=ranks.length-1; i>=0; i-- ){
            if(i==ranks.length-1){
                map.put(ranks[i],"Gold Medal");
            }else if(i==ranks.length-2){
                map.put(ranks[i],"Silver Medal");
            }else if(i==ranks.length-3){
                map.put(ranks[i],"Bronze Medal");
            }else{
                map.put(ranks[i],(ranks.length-i)+"");
            }
        }
        String[] res = new String[nums.length];
        for(int i = 0; i<nums.length; i++ ){
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
