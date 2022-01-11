

public class Solution4 {

    //4. 寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        double median1 = 0.0;
//        double median2 = 0.0;
//        double median = 0.0;
//
//        //加2表示包括中位数本身
//        int len = 2+len1/2+len2/2;
//        int[] nums = new int [len];
//
//        if(len1%2 == 0)//偶数
//            median1 = 1.0*(nums1[(len1/2)-1]+nums1[len1/2])/2;
//        else median1 = 1.0*nums1[len1/2];
//        if(len2%2 == 0)//偶数
//            median2 = 1.0*(nums2[(len2/2)-1]+nums2[len2/2])/2;
//        else median2 = 1.0*nums2[len2/2];
//        System.out.println("median1:"+median1);
//        System.out.println("median2:"+median2);
//
//
////        if(len1%2 ==0 && len2%2 == 0)
////            nums[len-1] = 1000001;
//        if(median1 < median2){
//            int i = len1/2;
//            int j = 0;
//            int k = 0;
//
//            while (i<len1 || j<=len2/2){
//                if(i>=len1){
//                    nums[k] = nums2[j];
//                    k++;j++;
//                    continue;
//                }
//                if(j>=len2/2){
//                    nums[k] = nums1[i];
//                    k++;i++;
//                    continue;
//                }
//                if(nums1[i] <= nums2[j]){
//                    nums[k] = nums1[i];
//                    k++;i++;
//                }else {
//                    nums[k] = nums2[j];
//                    k++;j++;
//                }
//            }
//            if(nums[len-1] == 0){
//                if((len-1)%2 == 0){
//                    median = 1.0*(nums[(len-1)/2-1]+nums[(len-1)/2])/2;
//                }else {
//                    median = 1.0*nums[(len-1)/2];
//                }
//            }else {
//                if(len%2 == 0){
//                    median = 1.0*(nums[len/2-1]+nums[len/2])/2;
//                }else {
//                    median = 1.0 * nums[len / 2];
//                }
//            }
//
//        }
//
//        System.out.println("median:"+median);


//        return median;
        return 1.0;



        //二分查找
    }

    public static void main(String[] args){
        int[] n1 = {1,2,3,4};
        int[] n2 = {5,6,7,8};
        findMedianSortedArrays(n1, n2);
    }
}