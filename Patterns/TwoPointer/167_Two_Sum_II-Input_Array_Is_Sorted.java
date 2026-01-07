/*
Problem: Two Sum II – Input Array Is Sorted
Platform: LeetCode #167
Pattern: Two Pointers
Difficulty: Medium

Approach:
- Use two pointers: left (start) and right (end)
- If sum == target → return indices
- If sum < target → move left
- If sum > target → move right


Time Complexity: O(n)

Space Complexity: O(1)
*/


public class 167_Two_Sum_II-Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int sum=0,l=0,r=numbers.length-1;
        int[] res = new int[2];
        while(l<r){
            sum=numbers[l]+numbers[r];
            if(sum==target){
                res[0]=l+1;
                res[1]=r+1;
                break;
            }
            else if(sum<target){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}
