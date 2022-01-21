public class Solution0011 {

    //11. 盛最多水的容器

    /*
    双指针
    area = max{min{height[i],height[j]} * Math.abs(j-i) |i,j属于height.lenght}
     */
    public int maxArea(int[] height) {
        int p=0, q=height.length-1;//p和q分别为头尾指针
        int max = 0;

        while (p<q){
            int min_height = height[p]<height[q]?height[p]:height[q];
            max = max>min_height*(q-p)?max:min_height*(q-p);
            if(height[p]<height[q]){
                p++;
            }else q--;
        }
        return max;
    }

    public static void main(String[] args){
        Solution0011 solution = new Solution0011();
//        int nums[] = {1,8,6,2,5,4,8,3,7};
//        int nums[] = {1,1};
        int nums[] = {1,2,1};
//        int nums[] = {1,8,6,2,5,4,8,3,7};


        System.out.println(solution.maxArea(nums));
    }
}