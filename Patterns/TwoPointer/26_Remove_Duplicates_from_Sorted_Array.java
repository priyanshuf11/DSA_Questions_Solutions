/*
Problem: Remove Duplicates from Sorted Array
Platform: LeetCode #26
Pattern: Two Pointers
Difficulty: Easy

Approach (Two Pointers):
- use two pointer
  - `i` for traversing the array
  - `updatedCount` tracks the index where the next distinct element should be placed
- skip duplicate elements, insert distinct elemts at `updatedCount`
- `updatedCount` represents the index after last distinct element and also count of unique elements

TC: O(n), SC: O(1)


*/

public class 26_Remove_Duplicates_from_Sorted_Array {
    
    public int removeDuplicates(int[] nums) {
        int updatedCount=1; // Tracks the index for placing the next distinct element

        if(nums.length==0){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            // add distinct elements at the `upadtedCount` index
            if(nums[i]!=nums[i-1]){
                nums[updatedCount]=nums[i];
                updatedCount++;
            }
        }
        return updatedCount;
    }
}
