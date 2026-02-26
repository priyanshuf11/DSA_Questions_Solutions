/*
 * Problem: Decode Ways
 * Platform: LeetCode #91
 * Pattern: Dynamic Programming (1D)
 * Difficulty: Medium
 * 
 * Intuition:
 * - Each digit or pair of digits may map to a letter (1–9, 10–26).
 * - At any index i, we decide how many valid decodings start from that position.
 * - If current digit is '0' → no decoding possible from here.
 * - Otherwise:
 *      - Take single digit → move to i+1
 *      - Take two digits (if valid 10–26) → move to i+2
 * 
 * Recurrence Relation:
 * Let f(i) = number of ways to decode substring starting at index i
 * - If s[i] == '0'
 *      f(i) = 0
 * - Otherwise
 *      f(i) = f(i+1)
 * - If valid two-digit number exists
 *      f(i) += f(i+2)
 * 
 * Approach 1 (DP Array — Bottom Up):
 * - Create dp[n+1]
 * - dp[i] stores number of decodings from index i to end
 * - Fill from right → left using recurrence
 * - Answer = dp[0]
 * 
 * Approach 2 (Space Optimisation):
 * - We only need next two states:
 *      next1 = f(i+1)
 *      next2 = f(i+2)
 * - Compute current and shift variables
 * - Eliminates DP array
 * 
 * Time Complexity:
 * - Both approaches: O(n)
 * 
 * Space Complexity:
 * - Approach 1: O(n)
 * - Approach 2: O(1)
 * 
 */



public class 91_decode_ways{

    public int numDecodingsForwardDP(String s) {
        if(s== null || s.length() ==0 || s.charAt(0)=='0') return 0; // edge cases

        int n=s.length();
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;

        for(int i=2;i<=n;i++){
            int oneDigit = Character.getNumericValue(s.charAt(i-1));
            int twoDigit = Integer.parseInt(s.substring(i-2,i));

            // 0 has no corresponding alphabet
            if(s.charAt(i-1) != '0' ){
                dp[i]+=dp[i-1];
            }
            // checks two digit number is in range 10 - 26
            if(twoDigit>=10 && twoDigit<=26){
                dp[i] +=dp[i-2];
            }
        }
        return dp[n];
    }

    // Backwards DP
    public int numDecodingsBackwardsDPMemoiation(String s) {
        int n= s.length();
        int[] dp = new int[n+1];

        dp[n] = 1;

        for(int i=n-1;i>= 0; i--){
            if(s.charAt(i) != '0'){

                dp[i] = dp[i+1];
                if(i<n-1 && (s.charAt(i) == '1' || s.charAt(i)== '2'&&s.charAt(i+1)<'7')) dp[i] +=dp[i+2];
            }
        }
        return dp[0];
    }

    //Space Optimised 
    public int numDecodings(String s) {
        int n= s.length();
        int dp1=1;
        int dp2=0;

        for(int i=n-1;i>= 0; i--){
            int curr = s.charAt(i) == '0' ? 0:dp1;
            if(i<n-1 && (s.charAt(i) == '1' || s.charAt(i)== '2'&&s.charAt(i+1)<'7')) curr +=dp2;
            dp2= dp1;
            dp1= curr;
        }
        return dp1;
    }
}
