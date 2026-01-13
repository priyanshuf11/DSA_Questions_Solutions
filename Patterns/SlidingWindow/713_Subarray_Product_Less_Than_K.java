/*
Problem: Subarray Product Less Than K
Platform: LeetCode #713
Pattern: Sliding Window (Variable Size)
Difficulty: Medium

Approach:
- Brute Force:
  - Fix a starting index
  - Expand subarray while product remains < k
  - Count all valid subarrays starting at that index

- Optimized Sliding Window:
  - Use two pointers with a running product
  - Expand window by moving `end`
  - Shrink window when product >= k
  - For each valid window, add (end - start + 1) to count

Key Insight:
- All subarrays ending at `end` and starting from `start` to `end`
  are valid once the window product < k

Time Complexity:
- Brute Force: O(n²)
- Optimized: O(n)

Space Complexity: O(1)
*/

public class 713_Subarray_Product_Less_Than_K {

    //------------------Brute Froce solution----------------------------
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n= nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int prod=1; // resets for each index
            int end=i;
            //expand the window  
            while(end<n && prod * nums[end] < k){
                prod *= nums[end];
                count++;
                end++;
            }
        }
        return count;
    }

    //------------------Optimised solution----------------------------

    public int numSubarrayProductLessThanKOptimal(int[] nums, int k) {
        if(k<=1) return 0; // no valid subarray possible since product >= 1

        int n= nums.length;
        int count=0;
        int start=0;
        int prod=1;

        for(int end=0;end<n;end++){
            prod *= nums[end];

            // shrink the window
            while(prod >=k){
                prod /= nums[start];
                start++;
            }
            count +=(end-start +1); // efficinetly counts all the possible subarray in the window
        }
        return count;
    }

}