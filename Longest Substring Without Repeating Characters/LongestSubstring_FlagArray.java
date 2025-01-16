// Optimal solution

class  LongestSubstring_FlagArray {
    public int lengthOfLongestSubstring(String s) {
        boolean[] flag = new boolean[256];

        int res=0;
        int start = 0;
        char[] arr = s.toCharArray();
        

        for(int i=0;i<arr.length;i++){
            char current = arr[i];
            if(flag[current]){
            res=Math.max(res,i-start);
            for(int k =start;k<i;k++){
                if(arr[k]==current){
                    start=k+1;
                    break;
                }
                flag[arr[k]]=false;
            }
            }
            else{
                flag[current]=true;
            }
        }
        res=Math.max(arr.length-start,res);

        return res;
    }
}