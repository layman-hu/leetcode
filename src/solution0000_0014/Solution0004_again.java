package solution0000_0014;

public class Solution0004_again {

    //4. 寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int total_left_num = (m+n+1)/2;

        int nums1_left = 0;
        int nums1_right = m;

        //nums1[i-1]<nums2[j] && nums2[j-1]<nums1[i]
        while (nums1_left<nums1_right){
            int i = nums1_left + (nums1_right-nums1_left+1)/2;//+1为上取整，这样保证i-1>=0
            int j = total_left_num - i;
            if(nums1[i-1]>=nums2[j]){
                //下一次区间[nums1_left, i-1]
                nums1_right = i-1;
            }else {
                //下一次区间[i, nums1_right]
                nums1_left = i;
            }
        }

        //i,j为中位数分割线
        int i = nums1_left;
        int j = total_left_num-i;

        //i==0，分割线左侧没有元素，令nums1_left_max等于无穷小
        int nums1_left_max = (i==0)?Integer.MIN_VALUE:nums1[i-1];
        //i==m,分割线右侧没有元素，令
        int nums1_right_min = (i==m)?Integer.MAX_VALUE:nums1[i];
        //j同理
        int nums2_left_max = (j==0)?Integer.MIN_VALUE:nums2[j-1];
        int nums2_right_min = (j==n)?Integer.MAX_VALUE:nums2[j];

        //找中位数
        if((m+n)%2==1){//最后合并的大数组为奇数个时
            //中位数为nums1_left_max和nums2_left_max其中的较大值
            //return Math.max(nums1_left_max,nums2_left_max);
            return (nums1_left_max>nums2_left_max)?nums1_left_max:nums2_left_max;
        }else {
            /*
            中位数1：nums1_left_max和nums2_left_max其中的较大值
            中位数2：nums1_right_min和nums2_right_min其中的较小值
             */
            //return (double)(Math.max(nums1_left_max,nums2_left_max) + Math.min(nums1_right_min,nums2_right_min))/2;
            return 1.0*((nums1_left_max>nums2_left_max?nums1_left_max:nums2_left_max) + (nums1_right_min<nums2_right_min?nums1_right_min:nums2_right_min))/2;
        }




    }

    public static void main(String[] args){
        int[] n1 = {1,2};
        int[] n2 = {3,4};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}