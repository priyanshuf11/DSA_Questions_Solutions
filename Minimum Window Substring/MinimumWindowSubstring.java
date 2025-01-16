class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // edge cases
        if(s== null || t== null ||s.length()==0 || t.length()==0 || s.length()<t.length()){
            return new String();
        }
        // initialise map to map character of t
        int[] map= new int[128];
        int count=t.length();
        int start=0,end=0;
        int minLen=Integer.MAX_VALUE;
        int startIndex=0;
        // map char of t , char except that in t are 0
        for(char c: t.toCharArray()){
            map[c]++;
        }

        char[] chs = s.toCharArray();
        // loop for sliding window- end expands to right
        while(end<s.length()){
            // if char of t is found decrease count
            if(map[chs[end++]]-->0){
                count--;
            }
            // found all char of t
            while(count ==0){

                // if this window is minimum update minLen
                if(end-start<minLen){
                    startIndex=start;
                    minLen=end-start;
                }
                // shrinking window from start
                if(map[chs[start++]]++ ==0){
                    count++;
                }
            }
        }
        //check if minLen is changed or not
        return minLen== Integer.MAX_VALUE? new String(): new String(chs,startIndex,minLen);
    }
}