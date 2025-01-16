class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] charFreqMap= new int[26];
        for(char c: s.toCharArray()){
            charFreqMap[c-'a']++;
        }
        for(char c:t.toCharArray()){
            if(charFreqMap[c-'a']==0){
                return false;
            }
            charFreqMap[c-'a']--;
        }
        return true;
    }
}