/*
Problem: Reverse String
Platform: LeetCode #344
Pattern: Two Pointers
Difficulty: Easy

Approach:
- Use two pointers: left (start) and right (end)
- swap s[left] and s[right]
- move both pointer closer to middle


Time Complexity: O(n)

Space Complexity: O(1)
*/

public class 344_Reverse_String {

    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        char temp;
        while(left<right){
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}