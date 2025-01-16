class AllAnagrams_CharFreqMap {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans= new ArrayList<>();
        int[] pFreqMap= new int[26];

         if (s.length() < p.length()) return ans;
        for(char c: p.toCharArray()){
            pFreqMap[c-'a']++;
        } 
        int[] windowFreqMap = new int[26];
        int windowsize = p.length();
        for(int i=0; i<windowsize;i++){
            windowFreqMap[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pFreqMap, windowFreqMap)){
            ans.add(0);
        }

        for(int i=windowsize;i<s.length();i++){
            windowFreqMap[s.charAt(i)-'a']++;

            windowFreqMap[s.charAt(i-windowsize)-'a']--;

            if(Arrays.equals(pFreqMap, windowFreqMap)){
                ans.add(i-windowsize+1);
            }
        }

        return ans;
    }

}