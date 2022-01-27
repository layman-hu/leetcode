package solution0000_0014;

public class Solution0009 {

    //9. 回文数
    public boolean isPalindrome(int x) {
        /*
        反转数字的位数已经达到原始数字位数的一半？
        由于整个过程我们不断将原始数字除以 10，
        然后给反转后的数字乘上 10，
        所以，当原始数字小于或等于反转后的数字时，
        就意味着我们已经处理了一半位数的数字了。

        记录官方题解思路，代码中我没有去实现
         */


        if(x<0) return false;//负数直接不是回文数
        int num_len = 0;

        int x_temp = x;
        while (x_temp != 0){
            x_temp /= 10;
            num_len++;
        }
        int half_x = 0;

        /*
        优化如下
        if(num_len%2 == 0){//x为偶数个
            for(int i=0; i<num_len/2; i++){
                int remainder = x%10;//余数
                half_x = 10*half_x + remainder;
                x /= 10;
            }
            return (x - half_x == 0)?true:false;
        }else {
            for(int i=0; i<num_len/2; i++){
                int remainder = x%10;//余数
                half_x = 10*half_x + remainder;
                x /= 10;
            }
            x /= 10;
            return (x - half_x == 0)?true:false;
        }
        */
        for(int i=0; i<num_len/2; i++){
            int remainder = x%10;//余数
            half_x = 10*half_x + remainder;
            x /= 10;
        }
        if(num_len%2==1) x /= 10;
        return (x - half_x == 0)?true:false;
    }

    public static void main(String[] args){
        Solution0009 solution0009 = new Solution0009();
        System.out.println(solution0009.isPalindrome(-101));
    }
}