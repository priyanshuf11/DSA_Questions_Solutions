/*
Problem: Permutation in String
Platform: LeetCode #567
Pattern: Sliding Window (Fixed Size + Frequency Match)
Difficulty: Medium


Approach:
- Build frequency array for s1
- Slide a window of size s1.length() across s2
- Maintain a frequency array for the current window
- At each step, compare both frequency arrays
- If they match, a permutation exists

Edge Cases:
- s1 longer than s2
- Repeated characters in s1
- Single-character strings

Time Complexity: O(n * 26) ≈ O(n)
Space Complexity: O(1)
*/


public class 567_Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {
       
        int[] freq1= new int[26];
        int[] freq2= new int[26];
         // map the char frequencies of s1
        for(char c : s1.toCharArray()){
            freq1[c-'a']++;
        }
        int l=s1.length();
        for(int i=0;i<s2.length();i++){
            freq2[s2.charAt(i)-'a']++; // map the char frequencies of s1
            if(i >=l) freq2[s2.charAt(i-l)-'a']--;  //slide the window forward
            if(Arrays.equals(freq1,freq2)) return true;
        }
        return false;
    }
}
