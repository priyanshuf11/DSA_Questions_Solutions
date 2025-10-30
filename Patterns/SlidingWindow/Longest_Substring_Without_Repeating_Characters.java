import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int maxLen=0;
        int start=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
                start = map.get(s.charAt(i))+1; 
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-start+1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring_naive(String s) {
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

    public int lengthOfLongestSubstring_Optimal(String s) {
        int n=s.length();
        if(n==0)
        {
            return 0;
        }
        int maxLength=0;
        int charIndex[]=new int[128];
        for(int i=0,j=0;j<n;j++)
        {
            char curr=s.charAt(j);
            i=Math.max(charIndex[curr],i);
            maxLength=Math.max(maxLength,j-i+1);
            charIndex[curr]=j+1;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring_flag_Optimal(String s) {
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
