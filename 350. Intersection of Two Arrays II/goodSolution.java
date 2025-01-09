class goodSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums3=new int[nums1.length+nums2.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                nums3[k++]=nums1[i++];
                j++;
            }
        }
        return  Arrays.copyOfRange(nums3, 0, k);
    }
}