
import java.util.HashMap;

public class Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II {


    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
        //find all the possible substring with k or more consonants
        //find all the possible substring with k+1 or more consonants
        // subtracting will give us ones with exactly k
    }

    private long atLeastK(String word, int k) {
        long ans = 0;
        int n = word.length();
        int left = 0, consonants = 0;
        HashMap<Character, Integer> vowelMap = new HashMap<>();


        // use a window with left and right as start and end
        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }

            while (vowelMap.size() == 5 && consonants >= k) {
                ans += n - right;  // all the substring in front will be valid so we ad all those
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) {
                        vowelMap.remove(leftChar); // reomving from map is necessary to find size correctly because count zero is still concidered in size
                    }
                } else {
                    consonants--;
                }
                left++;
            }
        }
        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}