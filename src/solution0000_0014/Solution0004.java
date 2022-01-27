package solution0000_0014;

public class Solution0004 {

    //4. 寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //二分查找
        //将短的数组放在nums1中
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        /*
        考虑：把nums1和nums2想象成一个大数组nums
        中位数：中位数定义，将一个集合分成两个子集，在中位数左边的子集一定小于中位数右边的子集
        这里定义：左边子集数量等于右边子集数量，或者比右边多1。这样，求出了左子集，右子集自然就得出来了
         */

        /*
        len = nums1.length+nums2.length=m+n;
        nums含奇数个元素，左子集个数:(len/2)+1=(len+1)/2
        nums含偶数个元素，左子集个数:len/2=(len+1)/2
        所以nums不论奇偶，左子集个数都可表示为:(len+1)/2=(m+n+1)/2
         */
        int total_left_subset_num = (m+n+1)/2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        /*
         使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]

         total_left_subset_num = i+j
         i,j分别代表nums1和muns2的中位数下标
         i-1和j-1表示在中位数左边，即元素分别在nums1和nums2的左子集
         */

        //定义nums1左右指针，当left和right重合时，搜寻结束

        int nums1_left = 0;
        int nums1_right = m;

        while(nums1_left<nums1_right){
            int i = nums1_left + (nums1_right-nums1_left+1)/2;
            int j = total_left_subset_num - i;
            if(nums1[i-1] > nums2[j]){
                // 下一轮搜索的区间 [nums1_left, i - 1]
                nums1_right = i-1;
            }else {
                // 下一轮搜索的区间 [i, nums1_right]
                nums1_left = i;
            }
        }
        int i = nums1_left;
        int j = total_left_subset_num - i;

        int nums1_left_max = ((i==0)?Integer.MIN_VALUE:nums1[i-1]);
        int nums1_right_min = ((i==m)?Integer.MAX_VALUE:nums1[i]);
        int nums2_left_max = ((j==0)?Integer.MIN_VALUE:nums2[j-1]);
        int nums2_right_min = ((j==n)?Integer.MAX_VALUE:nums2[j]);

        if((m+n)%2 == 1){
            //奇数个，此时中位数在左子集的最后一个
            return (nums1_left_max>nums2_left_max)?nums1_left_max:nums2_left_max;
        } else {
            //偶数个，此时中位数为左子集最大值与右子集最小值的均值
            return 1.0*((nums1_left_max>nums2_left_max?nums1_left_max:nums2_left_max) +(nums1_right_min<nums2_right_min?nums1_right_min:nums2_right_min) )/2;
        }
    }

    public static void main(String[] args){
        int[] n1 = {1,2};
        int[] n2 = {3,4};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}