class optimalSolution {
    public int removeDuplicates(int[] nums) {
        int updatedCount=1;
        if(nums.length==0){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[updatedCount]=nums[i];
                updatedCount++;
            }
        }
        return updatedCount;
    }
}