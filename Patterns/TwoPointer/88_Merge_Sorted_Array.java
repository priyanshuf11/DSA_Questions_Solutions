/*
Problem: Merger Sorted Array
Platform: LeetCode #88
Pattern: Two Pointers
Difficulty: Easy

Approach :
- Use two pointers starting from the end of `nums1`
  - `i` points to the last valid element in `nums1` (index m - 1)
  - `n2` points to the last element in `nums2` (index n - 1)
  - `j` points to the last position of `nums1`
- Larger elements are easier to place when filling from the end
- Compare the largest remaining elements of `nums1` and `nums2`
- Place the larger element at index `j` and move the corresponding pointer

TC: O(m + n), SC: O(1)
*/

public class 88_Merge_Sorted_Array {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=nums1.length-1;
        int n2=n-1;

        while(n2>=0){
            if(i>=0 && nums1[i]>nums2[n2]){
                nums1[j--]=nums1[i--];
            }
            else{
                nums1[j--]=nums2[n2--];
            }
        }
    }
}
