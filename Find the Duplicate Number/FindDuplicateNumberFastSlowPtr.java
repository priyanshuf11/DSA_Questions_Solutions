class FindDuplicateNumberFastSlowPtr {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];

            // if array contains duplicate a loop will form here
        }while(slow!=fast);

        slow=0; // reset slow ptr

        while(slow!=fast){
            //check the entry point of loop (duplicate element)
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}