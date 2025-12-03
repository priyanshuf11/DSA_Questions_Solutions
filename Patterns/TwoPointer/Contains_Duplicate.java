
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate_Better(int[] nums) {
        Set<Integer> numSet=new HashSet<>();

        for(int num: nums){
            if(numSet.contains(num)){
                return true;
            }
            numSet.add(num);
        }
        return false;
    }

    public static boolean containsDuplicate_Optimal(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            int key = nums[i];
            int j = i - 1;
            // insertion sort logic
            while (j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            if (j >= 0 && nums[j] == key)
                return true;
            nums[j + 1] = key; // the key settles at the end
        }
        return false;
    }

}
