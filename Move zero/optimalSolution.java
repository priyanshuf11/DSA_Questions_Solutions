class optimalSolution {
    public void moveZeroes(int[] nums) {
        int temp,j;
        for(j=0;j<nums.length;j++){
            if(nums[j]==0){
                break;
            }
        }
        for(int i=j+1;i<nums.length;i++){
            if(nums[i]!=0){
                temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
        }
        
    }
}