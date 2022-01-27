package solution0000_0014;

public class Solution0014 {

    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        boolean char_flag = true;//初始值为真，当前缀不同时为假
        int strs_len = strs.length;
        StringBuffer stringBuffer = new StringBuffer();

        char char_temp = ' ';
        int count = 0;
        while (char_flag){

            try {
                char_temp = strs[0].charAt(count);
                for(int i=1; i<strs_len; i++){
                    if (char_temp != strs[i].charAt(count)){
                        char_flag = false;
                        break;
                    }
                }
                if(char_flag) {
//                    System.out.print(char_temp);
                    stringBuffer.append(char_temp);
                }
                count++;
            }
            catch (Exception e){
                 //某一字符串到达尾部，判定结束
                char_flag = false;
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args){
        Solution0014 solution = new Solution0014();
//        String []strs = {"flower","flow","flight"};
//        String []strs = {"dog","racecar","car"};
        String []strs = {"123456","1234567","12345678","123456789"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}