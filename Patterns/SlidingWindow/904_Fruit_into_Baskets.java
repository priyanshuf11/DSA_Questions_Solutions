/*
Problem: Fruit Into Baskets
Platform: LeetCode #904
Pattern: Sliding Window (At most K distinct)
Difficulty: Medium

Approach:
- Use sliding window with a HashMap to track fruit counts
- Expand right pointer to include fruits
- Shrink left pointer when distinct fruit types exceed 2
- Track maximum window size

TC: O(n)
SC: O(1) (at most 2 keys in map)
*/


import java.util.HashMap;
import java.util.Map;

public class 904_Fruit_into_Baskets {
    public int totalFruit(int[] fruits) {

        if (fruits == null || fruits.length == 0) return 0;

        Map<Integer,Integer> map = new HashMap<>();
        int maxWindow=0;
        int l=0,r=0;
        while(r<fruits.length){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);

            //ensure window contains at most 2 distinct fruit types
            while(l<=r && map.size()>2){
                 // shrink the window
                map.put(fruits[l],map.get(fruits[l])-1);
                
                if(map.get(fruits[l])==0){
                    // remove fruit type when its count drops to zero
                    map.remove(fruits[l]); 
                }
                l++;
            }
            maxWindow=Math.max(maxWindow,r-l+1);
            r++; 
        }
        return maxWindow;
    } 
}
