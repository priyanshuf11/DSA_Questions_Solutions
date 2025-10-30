import java.util.Arrays;

public class Permutation_in_String {
    
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

    static {
        for(int i = 0; i < 300; i++) {
            checkInclusion_Optimal("", "");
        }
    }
    public static boolean checkInclusion_Optimal(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int search = 0;
        int win = 0;

        for(int i = 0; i < s1.length(); i++) {
            search += s1.charAt(i) * s1.charAt(i);
            win += s2.charAt(i) * s2.charAt(i);
        }

        if(search == win) {
            return true;
        }

        for(int i = 0; i < s2.length() - s1.length(); i++) {
            win -= s2.charAt(i) * s2.charAt(i);
            win += s2.charAt(s1.length() + i) * s2.charAt(s1.length() + i);
            if(search == win) {
                return true;
            }
        }

        return false;
        
    }
}
