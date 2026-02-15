/*
Problem: 3Sum
Platform: LeetCode #15
Pattern: Two Pointers + Sorting
Difficulty: Medium

Approach:
- Sort the array
- Fix one element and reduce to 2Sum-II
- Skip duplicates to avoid repeated triplets

TC: O(n^2)
SC: O(1) (excluding output)
*/

import java.util.*;
public class 15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n=nums.length;

        if(nums == null || nums.length<3){
            return new ArrayList<>(result);
        }

        Arrays.sort(nums);  // sort the array to get array like (-ve, 0, +ve)

        for(int i=0;i<n-2;i++){
            if(nums[i]>0) break; // for sum=0 one number must be -ve
            if(i>0 && nums[i]==nums[i-1]){
                continue; // skip duplicates
            }

            // reduce to Two Sum II using two pointers

            int l= i+1;
            int r= n-1;

            while(l<r){
                int sum = nums[i]+ nums[l]+ nums[r];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;

                    while(l < r && nums[l]== nums[l-1]){ l++;}
                    while(l < r && nums[r]== nums[r+1]){ r--;}
                }
                else if(sum >0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        for (int i = 0; i < max; i++) {
          
        }
        return new ArrayList<>(result);
    }
}
