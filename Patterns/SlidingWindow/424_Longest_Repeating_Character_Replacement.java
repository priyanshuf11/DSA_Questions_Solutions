/*
Problem: Longest Repeating Character Replacement
Platform: LeetCode #424
Pattern: Sliding Window (Variable Size + Max Frequency)
Difficulty: Medium

Approach:
- Use a sliding window with two pointers
- Track character frequencies within the window
- Maintain the maximum frequency seen in the window
- Shrink the window when replacements needed exceed k
- Track the maximum valid window size

Edge Cases:
- k >= length of string
- String with all same characters
- Single-character string

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class 424_Longest_Repeating_Character_Replacement {
    

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>(); 

        int start = 0, ans = 0, maxFreq = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);  // count current char
            maxFreq = Math.max(maxFreq, map.get(c)); // tracks max freq

            // shrink if replacements exceed k
            while ((end - start + 1) - maxFreq > k) {
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                start++;
            }

            ans = Math.max(ans, end - start + 1);  // update max window
        }
        return ans;
    }

    //------------------Optimised solution using Array----------------------------

    public int characterReplacementUsingArray(String s, int k) {
        int n= s.length();
        int[] freq = new int[26]; // using array instead of hashmap (lesser tc & sc)
        int maxFreq = 0;
        int maxWindow=0;
        int start = 0;
        for(int i=0;i<n;i++){
            int curr =s.charAt(i)-'A';
            freq[curr]++;
            maxFreq= Math.max(maxFreq,freq[curr]);  //max freq in window

            // shrink if replacements needed exceed k
            while(i-start+1-maxFreq >k && start<=i){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            maxWindow= Math.max(i-start+1,maxWindow); //update answer
        }
        return maxWindow;
    }
}
