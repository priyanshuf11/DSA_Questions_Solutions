/*
Problem: Container With Most Water
Platform: LeetCode #11
Pattern: Two Pointers
Difficulty: Medium

Approach 1 (Two Pointers):
- use two pointer on two ends
- water in current window = min(heights of both limits) * width
- Water in current window = min(height[pt1], height[pt2]) * (pt2 - pt1)
- update maxwater if current water is larger
- move the smaller limit inwards by 1
TC: O(n), SC: O(1)

Approach 2 (Two Pointers):
- Same logic as Approach 1, but replace conditional pointer movement with loops
- Skipping all heights less than or equal to the current limiting height 
  avoids unnecessary comparisons and calculations
TC: O(n) (slightly faster in practice), SC: O(1)
*/

public class 11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int n= height.length;
        int pt1=0;
        int pt2=n-1;
        int maxwater=0;
        while(pt1<pt2){
            int volume= Math.min(height[pt1],height[pt2]) *(pt2-pt1);
            maxwater=Math.max(maxwater,volume);

            // move the pointer at smaller height
            if(height[pt1]<height[pt2]){
                pt1++;
            }else{
                pt2--;
            }
        }
        return maxwater;
    }

    //-------------------------------------------optimied solution usning loops-------------------------------------

    public int maxAreaOptimised(int[] height) {
        int pt1=0;
        int pt2=height.length-1;
        int h=0;
        int maxwater=0;
        while(pt1<pt2){
            h= Math.min(height[pt1],height[pt2]); 
            maxwater=Math.max(maxwater,h*(pt2-pt1));

            // using loops instead of conditons skip many unnecessary iterations
            while(pt1<pt2 && height[pt1]<=h) pt1++; 
            while(pt1<pt2 && height[pt2]<=h) pt2--;
        }
        return maxwater;
    }

}
