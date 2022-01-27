package solution0000_0014;

public class Solution0008 {

    //8. 字符串转换整数 (atoi)
    public static int myAtoi(String s) {

        int num = 0;
        int sign_flag = 1;
        int sign_num = 0;//符号个数，+-12输出0，你敢信
        int num_flag = 0;
        for(char c:s.toCharArray()){
            if(c == ' ' && num_flag == 0 && sign_num == 0) continue;
            if(c == '+' && num_flag == 0){
                sign_num++;
                continue;
            }
            if(c == '-' && num_flag == 0) {
                sign_flag = -1;
                sign_num++;
                continue;
            }
            else if(c>='0' && c<='9'){
                if(sign_num>1) return 0;

                //Integer.MIN_VALUE = -2147483648
                if(sign_flag == -1 ){
                    if(num < Integer.MIN_VALUE/10)
                        return Integer.MIN_VALUE;
                    if(num == Integer.MIN_VALUE/10 && (c-'0')>8)
                        return Integer.MIN_VALUE;
                }

                //Integer.MAX_VALUE = 2147483647
                if(num > Integer.MAX_VALUE/10) return Integer.MAX_VALUE;
                if(num == Integer.MAX_VALUE/10 && (c-'0')>7) return Integer.MAX_VALUE;

                num = num*10 + ((sign_flag>0)?(c-'0'):-(c-'0'));
                num_flag = 1;
            }else return (num_flag == 0)?0:num;
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(myAtoi(" + 123"));
        System.out.println(-2147483648);
    }
}