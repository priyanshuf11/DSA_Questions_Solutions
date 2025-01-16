class NextPermutation {
    public void nextPermutation(int[] nums) {
        int b=-1; // variable to store breakpoint index : nums[i]<nums[i+1]
        int s=-1; // next big element after breakpoint
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                b=i;
                break;
            }
            
        }
        if(b==-1){
            reverse(nums,0);
        }
        else{
            for(int i=nums.length-1;i>0;i--){
                if(nums[i]>nums[b]){
                    s=i;
                    break;
                }
            }
        
            swap(nums,b,s);
            reverse(nums,b+1);
        }
    }

    
    private void reverse(int[] nums, int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
}