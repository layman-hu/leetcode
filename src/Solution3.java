import java.util.HashMap;

public class Solution3 {

    //3. 无重复字符的最长子串
    /*
    思路：散列表，滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;//最大长度
        int fast_point = 0;
        int slow_point = 0;

        int str_len = s.length();
        /*
        key:char
        value:index
         */
        HashMap<Character,Integer> hashMap = new HashMap<>();

        for(fast_point=0; fast_point<str_len; fast_point++){
//            if(!hashMap.containsKey(s.charAt(fast_point))){
//                hashMap.put(s.charAt(fast_point),fast_point);
//                result = Math.max(result, fast_point-slow_point+1);
//            }else {
//                slow_point = Math.max(hashMap.get(s.charAt(fast_point))+1, slow_point);
//                hashMap.replace(s.charAt(fast_point), fast_point);
//                result = Math.max(result, fast_point-slow_point+1);
//            }

            if(hashMap.containsKey(s.charAt(fast_point))){
//                slow_point = Math.max(hashMap.get(s.charAt(fast_point))+1, slow_point);
                slow_point = (hashMap.get(s.charAt(fast_point))+1>slow_point)?(hashMap.get(s.charAt(fast_point))+1):slow_point;
            }

            hashMap.put(s.charAt(fast_point), fast_point);
//            result = Math.max(result, fast_point-slow_point+1);
            result = (result>fast_point-slow_point+1)?result:(fast_point-slow_point+1);
        }

        return result;
    }

    public static void main(String[] args){
//        String s = "1234";
//        System.out.println(s.charAt(0));

//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}