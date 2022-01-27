package solution0000_0014;

public class Solution0005 {

    //5. 最长回文子串
    public static String longestPalindrome(String s) {
        int odd_palindrome_len = 1;//奇数回文序列长度
        int odd_palindrome_index = 0;
        int even_palindrome_len = 0;//偶数回文序列长度
        int even_palindrome_index = 0;//偶回文序列中点下标，取左边下标

        int len = s.length();
        for(int i=0; i<len; i++){
            int even_index_temp = i;
            int even_len_temp = 0;
            int interval = 0;
            while (even_index_temp-interval>=0 && even_index_temp+1+interval<len){
                if(s.charAt(even_index_temp-interval) == s.charAt(even_index_temp+1+interval)){
                    even_len_temp += 2;
                    interval++;
                }else break;
            }
            if(even_len_temp > even_palindrome_len){
                even_palindrome_len = even_len_temp;
                even_palindrome_index = even_index_temp;
            }

            int odd_index_temp = i;
            int odd_len_temp = 1;
            int interval2 = 1;
            while (odd_index_temp-interval2>=0 && odd_index_temp+interval2<len){
                if(s.charAt(odd_index_temp-interval2) == s.charAt(odd_index_temp+interval2)){
                    odd_len_temp += 2;
                    interval2++;
                }else break;
            }
            if(odd_len_temp > odd_palindrome_len){
                odd_palindrome_len = odd_len_temp;
                odd_palindrome_index = odd_index_temp;
            }
        }
        if(odd_palindrome_len>even_palindrome_len){
            return s.substring(odd_palindrome_index-(odd_palindrome_len/2),odd_palindrome_index+(odd_palindrome_len/2)+1);
        }else {
            return s.substring((even_palindrome_index+1)-(even_palindrome_len/2),even_palindrome_index+(even_palindrome_len/2)+1);
        }

    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("ac"));
    }
}