/*
Problem: Trapping Rain Water
Platform: LeetCode #42
Pattern: Prefix Max / Two Pointers
Difficulty: Hard


Approach 1 (Prefix Max):
- Precompute tallest bar to left and right of each index
- Water at index = min(leftMax, rightMax) - height[i]
TC: O(n), SC: O(n)

Approach 2 (Two Pointers):
- Use left and right pointers with running max heights
- Always move pointer with smaller max
TC: O(n), SC: O(1)
*/


public class 42_Trapping_Rain_Water {
    
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n= height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int ans=0;

        rightMax[n-1]= height[n-1];
        leftMax[0]= height[0];

        for(int i=1;i<n;i++){
            leftMax[i]= Math.max(leftMax[i-1],height[i]);
            rightMax[n-i-1]= Math.max(rightMax[n-i],height[n-i-1]);
        }
        for(int i=0;i<n;i++){
            ans+= Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }

    //-------------------------------------------greedy solution-------------------------------------

    public int  trapTwoPointers(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;        
    }
}