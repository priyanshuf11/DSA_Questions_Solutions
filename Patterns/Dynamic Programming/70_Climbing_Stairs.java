/*
Problem: Climbing Stairs
Platform: LeetCode #70
Pattern: Dynamic Programming (1D)
Difficulty: Easy

Approach:
- Recursive solution (for understanding, not optimal)
- DP using array
- DP optimized to constant space

TC: O(n)
SC: O(1) for optimized version
*/


public class 70_Climbing_Stairs {

    //Recursive solution
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    //------------------DP solution with Array ----------------------------

    public int climbStairsDPArray(int n) {
        if(n<=1){
            return 1;
        }
        int[] arr = new int[n+1];
        arr[0]=1;
        arr[1]=1;

        for(int i=2;i<=n;i++){
            int a=arr[i-1];
            int b=arr[i-2];
            arr[i]=a+b;
        }
        return arr[n];
    }

    //------------------DP solution optimised----------------------------

    public int climbStairsDPOptimised(int n) {
        if(n<=1){
            return 1;
        }
        int p1=1;
        int p2=1;

        for(int i=2;i<=n;i++){
            int temp= p2;
            p2= p2+p1;
            p1 = temp;
        }
        return p2;

    }


}
