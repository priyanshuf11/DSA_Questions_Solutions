class FindDuplicateNumber_IndexSort {
    public int findDuplicate(int[] nums) {
       int len=nums.length;
       for(int i=0;i<len;){
        int n=nums[i];
        if(n==i+1)   //checks if the number is in its proper indexi.e 1 at 0, 2 at 1, etc.
        {
            i++;
        }
        else if(n==nums[n-1])  //checks if the number (not present at its proper position) matches with the number which is at its proper position ex: 2 at index 4 is checked if 2 is also at index 1
        {
            return n;
        }
        else  //if both cases fail -> swap 
        {
            nums[i]=nums[n-1];
            nums[n-1]=n;
        }
         
       }
       return 0;
    }  
}