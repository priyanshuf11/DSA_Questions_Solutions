class  LongestSubstring_HashSet {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> sh = new HashSet<>();
        int maxcount=0;
        int start=0;
        for(int end=0;end<s.length();end++){
            char c =s.charAt(end);

            while(sh.contains(c)){
                sh.remove(s.charAt(start));
                start++;
            }
            sh.add(c);
            maxcount=Math.max(maxcount,end-start+1);
            
        }
        return maxcount;
    }
}