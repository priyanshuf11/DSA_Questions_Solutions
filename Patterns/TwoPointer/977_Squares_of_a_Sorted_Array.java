/*
Problem: Squares of a Sorted Array
Platform: LeetCode #977
Pattern: Two Pointers/ Sorting
Difficulty: Easy


Approach 1 (Sorting):
- Replace negative values with their absolute values
- Sort the array
- Square each element in place
- !! note:this approach mutates the input array

TC: O( nlog n ), SC: O(1)

Approach 2 (Two Pointers):
- Use `l` and `r` pointers on both end of the nums array
- use extra array to store the squares
- Ignoring signs, the array behaves like:
  (non-increasing negatives, 0, non-decreasing positives)
- Compare absolute values at `l` and `r`
- Place the larger square at the end of the result array and move inward

TC: O(n), SC: O(n)
*/

public class 977_Squares_of_a_Sorted_Array {
    
    // Approach 1 : Sorting

    public int[] sortedSquaresUsingSorting(int[] nums) {
        int n= nums.length;
        // make -ve numbers +ve
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i]; // fill squares in place
        }
        return nums;
    }

    // Approach 2 : Optimised time complexity

    public int[] sortedSquaresExtraSpace(int[] nums) {
        int n= nums.length;
        int l=0;
        int r=n-1;
        int idx=n-1; // pointer to fill squares
        int[] ans = new int[n]; // O(n) extra space
        while(l<=r){
            if(Math.abs(nums[l])> Math.abs(nums[r])){
                ans[idx--]=nums[l]*nums[l];
                l++;
            }
            else{
                ans[idx--] = nums[r]*nums[r];
                r--;
            }
        }
        return ans;
    }
}