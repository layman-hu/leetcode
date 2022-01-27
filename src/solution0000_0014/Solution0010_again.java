package solution0000_0014;

public class Solution0010_again {

    //10. 正则表达式匹配
    public boolean isMatch(String s, String p) {
        int s_len = s.length(),p_len = p.length();

        boolean table[][] = new boolean[s_len+1][p_len+1];

        table[0][0] = true;
        //初始化第一行
        for(int j=1; j<p_len+1; j++){
            char c = p.charAt(j-1);
            if (c == '*'){
                if(j>1) {
                    table[0][j] = table[0][j - 2];
                }else table[0][j] = true;
            }else table[0][j] = false;
        }

        //生成第二行到最后一行
        for(int i=1; i<s_len+1; i++){
            char ch1 = s.charAt(i-1);
            for(int j=1; j<p_len+1; j++){
                char ch2 = p.charAt(j-1);
                if(ch2 == ch1 || ch2 == '.'){
                    table[i][j] = table[i-1][j-1];
                }else if(ch2 == '*'){
                    if(j>1){
                        if(table[i][j-2]){
                            table[i][j] = true;
                        }else{
                            char pre = p.charAt(j-2);
                            if(pre == ch1 || pre == '.'){
                                table[i][j] = table[i-1][j-1];
                            }
                        }
                    }
                }

            }
        }

        return table[table.length-1][table[0].length-1];
    }

    public static void main(String[] args){
        Solution0010_again solution = new Solution0010_again();
//        System.out.println(solution.isMatch("ab",".*"));
//        System.out.println(solution.isMatch("aab","c*a*b"));
        System.out.println(solution.isMatch("mississippi","mis*is*p*."));

    }
}