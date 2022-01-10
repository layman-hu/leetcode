import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {
    //1.哈希表
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        /*
        key:target-nums[i]
        value:i
         */
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i=0; i<len; i++){
            if(hashMap.containsKey(nums[i])){
                return new int[]{i, hashMap.get(nums[i])};
            }
            hashMap.put(target-nums[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args){
        int i = 0;
        int len_count = 0;
        int target = 0;
        int[] n = new int[4];
        Scanner in = new Scanner(System.in);
        for(i=0 ; i<5; i++) {
            if(i == 4){
                target = in.nextInt();
                break;
            }
            len_count++;
            n[i] = in.nextInt();
        }
        in.close();
        System.out.println("target:"+target);
        System.out.println("i:"+i+" len_count:"+ len_count);
        int[] result = twoSum(n,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}