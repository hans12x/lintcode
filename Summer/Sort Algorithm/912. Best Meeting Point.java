/*912. Best Meeting Point
中文English
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example
Example 1:

Input:
[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output:
6

Explanation:
The point `(0,2)` is an ideal meeting point, as the total travel distance of `2 + 2 + 2 = 6` is minimal. So return `6`.
Example 2:

Input:
[[1,1,0,0,1],[1,0,1,0,0],[0,0,1,0,1]]
Output:
14
*/
public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for (int i = 0;i<grid.length ;i++ ){
            for (int j = 0;j < grid[0].length ;j++ ){
                if (grid[i][j]==1){
                    x.add(i);
                    y.add(j);
                } 
            } 
        }
        return getMD(x)+getMD(y);
    }
    //best meeting point must at the middle of each two people.
    private int getMD(List<Integer>z){
        Collections.sort(z);
        int i = 0, j = z.size()-1,res = 0;
        while(i<j){
            res += z.get(j)-z.get(i);
            j--;
            i++;
        }
        return res;
    }
}