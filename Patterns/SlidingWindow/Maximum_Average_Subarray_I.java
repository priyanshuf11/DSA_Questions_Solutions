
public class Maximum_Average_Subarray_I{
    public double findMaxAverage(int[] nums, int k) {
        long total=0;

        for(int i=0;i<k;i++){
            total+= nums[i];
        }
        
        long maxSum=  total;
        for(int i=k;i< nums.length;i++){
            total = total + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, total);
        }
        return (double) maxSum/k;
    }
}

public class Maximum_Average_Subarray_I_Optimal {
    public double findMaxAverage(int[] nums, int k) {
        long total=0;

        for(int i=0;i<k;i++){
            total+= nums[i];
        }
        
        long maxSum=  total;
        for(int i=k;i< nums.length;i++){
            total = total + nums[i] - nums[i-k];
            maxSum =maxSum> total ? maxSum : total;
        }
        return (double) maxSum/k;
    }
}
