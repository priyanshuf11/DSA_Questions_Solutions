class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // edge cases
        if(s == null || s.length()==0){
            return "";
        }
        // for the start and end of palindromic substring
        int start=0;
        int end=0;

        //iterate throughout string
        for(int i=0;i<s.length();i++){
            //if the palindrone is odd in length 
            //i.e. one middle element so left and right start from same position
            int odd= ExpandAroundCenter(s,i,i);
            //if the palindrome is even lengthed, two middle elements
            int even= ExpandAroundCenter(s,i,i+1);

            //compare odd even
            int max_len=Math.max(odd,even);

            //update start end accordingly
            if(max_len> end-start){
                start=i-(max_len-1)/2;
                end=i+max_len/2;
            }
        }
        return s.substring(start,end+1);
    }

    //moves left and right furthur only if they are equal and inside the length of string
    private int ExpandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}