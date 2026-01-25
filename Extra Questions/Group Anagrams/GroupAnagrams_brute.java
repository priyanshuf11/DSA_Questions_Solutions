// lenthy approach , not good 2536ms
class GroupAnagrams_brute {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        List<List<String>> ans = new ArrayList<>();
        boolean[] flag = new boolean[n];
        for(int i=0;i<n;i++){
            if(flag[i]){
                continue;
            }
            else{
                List<String> current = new ArrayList<>();
                current.add(strs[i]);
                int[] charFreq = new int[26];
                for(char c:strs[i].toCharArray()){
                    charFreq[c-'a']++;
                }
                for(int j=i+1;j<n;j++){
                    int[] charFreq2 = new int[26];
                    for(char c:strs[j].toCharArray()){
                        charFreq2[c-'a']++;
                    }
                    if(Arrays.equals(charFreq,charFreq2)){
                        current.add(strs[j]);
                        flag[j]=true;
                    }
                }
                flag[i]=true;
                
                ans.add(current);
            }
        }
        return ans;
    }
}