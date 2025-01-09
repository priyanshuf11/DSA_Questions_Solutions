public class optimalSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=nums1.length-1;
        int n2=n-1;

        while(n2>=0){
            if(i>=0 && nums1[i]>nums2[n2]){
                nums1[j--]=nums1[i--];
            }
            else{
                nums1[j--]=nums2[n2--];
            }
        }
    }
}
