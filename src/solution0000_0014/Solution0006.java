package solution0000_0014;

public class Solution0006 {

    //6. Z 字形变换
    public static String convert(String s, int numRows) {
        int num_loop = 0;
        int len = s.length();

        if(numRows == 1) {
            return s;
        }
        else if(numRows > 1) {
            num_loop = numRows*2-2;
        }
        String result = "";
        for(int i=0; i<numRows; i++){
            if(i==0 || i==numRows-1){
                int j = 0;
                while(i+j*num_loop<len){
                    System.out.print(s.charAt(i+j*num_loop));
                    result += s.charAt(i+j*num_loop);
                    j++;
                }
            }else {
                int j = 0;
                /*
                除了第一行和最后一行，其余行都是两个元素一组，以num_loop为一个循环
                例子：
                P   A   H   N
                A P L S I I G
                Y   I   R
                第二行中AP一组，LS一组，II一组，i=1（i从0到numRows-1）
                其中A与P的关系可以表示为，A和L的前i*2个元素
                同理L与S的关系表示为，L和I的前i*2个元素

                 */
                while (i+j*num_loop<len && i+(j+1)*num_loop-i*2<len){
                    System.out.print(s.charAt(i+j*num_loop));
                    System.out.print(s.charAt(i+(j+1)*num_loop-i*2));

                    result += s.charAt(i+j*num_loop);
                    result += s.charAt(i+(j+1)*num_loop-i*2);
                    j++;
                }
                if(i+j*num_loop<len){
                    System.out.print(s.charAt(i+j*num_loop));
                    result += s.charAt(i+j*num_loop);
                }
            }

        }
        return result;
    }

    public static void main(String[] args){
        convert("PAYPALISHIRING", 3);
    }
}