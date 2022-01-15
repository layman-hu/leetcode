

public class Solution0007 {

    //7. 整数反转
    /*
    2^31-1=2147483647
    -2^31=-2147483648
           1534236469
           9646324351
     */

    public static int reverse(int x) {
        int result = 0;
//        int num_flag = x>0?1:-1;
        while (x != 0){
            int remainder = x%10;
            /*
            if((result*10 + remainder)<Integer.MIN_VALUE || (result*10 + remainder)>Integer.MAX_VALUE)
                return 0;
            当result*10 + remainder溢出时，他仍然是整数类型，32位，溢出位丢失，导致判定失败
            换位思考，将不等式两边同时除以10即可
            即
            result + remainder/10<Integer.MIN_VALUE/10
            和result + remainder/10>Integer.MAX_VALUE/10

            进一步等价于
            result<Integer.MIN_VALUE/10
            和result>Integer.MAX_VALUE/10
             */
            if(result<Integer.MIN_VALUE/10 || result>Integer.MAX_VALUE/10)
                return 0;
            result = result*10 + remainder;
            x /= 10;
        }
        return result;
        /*
        失败案例
        9646324351越界了
         */
//        int zero_flag = 1;
//        int num_flag = x>0?1:-1;
//        x = x>0?x:-x;
//        StringBuilder builder = new StringBuilder();
//
//        while (x>=10){
//            int remainder = x%10;
//            x /= 10;
//            if(remainder == 0 && zero_flag == 1){
//                continue;
//            }else if(remainder != 0){
//                zero_flag = 0;
//            }
//            builder.append(String.valueOf(remainder));
//        }
//        builder.append(String.valueOf(x));
//
//        int result = num_flag*Integer.valueOf(builder.toString());
//        if(result<(-1*1L<<32) || result>(1L<<32)-1) return 0;
//
//        System.out.print(num_flag>0?"":"-");
//        System.out.print(builder.toString());
//        System.out.println();
//
//        return result;
    }

    public static void main(String[] args){
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469));
//        System.out.println(reverse(0));
        /*
        2^31-1=2147483647
        -2^31=-2147483648
        9646324351
        2147483647

         */
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}