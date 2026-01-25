/*
Problem: House Robber
Platform: LeetCode #198
Pattern: Dynamic Programming (1D)
Difficulty: Medium

Intuition:
- Classic take-or-skip DP
- If we rob house i:
    total = nums[i] + best till (i-2)
- If we skip house i:
    total = best till (i-1)
-recursive relation:  
    f(i) = max(f(i-1), nums[i] + f(i-2))

Approach 1 (DP with memo):
- Using memoiation / Array,
- memo[i] stores max money from first i houses
- Answer = memo[n]

Approach 2 (Space Optimisation):
- There is an optimal way to solve this by removing memo
- We don’t actually need the full array
- Only the last two states are required
- prev = f(i-2), curr = f(i-1)

TC:
- Both approaches: O(n)

SC:
- Approach 1: O(n)
- Approach 2: O(1)
*/


public class 198_House_Robber {
    public int robWithMemo(int[] nums) {
        if(nums.length ==0) return 0;
        int[] memo = new int[nums.length+1];
        memo[0]=0;
        memo[1] = nums[0];
        for(int i=1;i<nums.length;i++){
            int val = nums[i];
            memo[i+1]= Math.max(memo[i], memo[i-1]+val);
        }
        return memo[nums.length];
    }

    //-------------Without Using Memo/DP ------------------
    
    public int robWithoutMemo(int[] nums) {
        if(nums.length ==0) return 0;
        int n= nums.length;
        int prev=0;
        int curr= nums[0];
        for(int i=1;i<n;i++){
            int max= Math.max(prev+ nums[i],curr);
            prev=curr;
            curr=max;
        }
        return curr;


    }
}