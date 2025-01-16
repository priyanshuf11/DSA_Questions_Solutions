class KthLargestWithSort {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int i=nums.length;
        while(k>0){
            k--;
            i--;
        }
        return nums[i];
    }
}