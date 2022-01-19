public class Solution0010 {

    //10. 正则表达式匹配
    public boolean isMatch(String s, String p) {
        boolean table[][] = new boolean[s.length()+1][p.length()+1];

        table[0][0] = true;

        //初始化第一行
        for(int j=1; j<table[0].length; j++){
            char c = p.charAt(j-1);
            if(j>1){
                if(c == '*')
                    table[0][j] = table[0][j-2];
                else table[0][j] = false;
            }else {
                //此时，*前无字符，*代表0个字符
                if(c == '*')
                    table[0][j] = true;
            }
        }

        //生成第二行至最后一行
        for(int i=1; i<table.length; i++){
            char ch1 = s.charAt(i-1);
            for(int j=1; j<table[i].length; j++){
                char ch2 = p.charAt(j-1);
                if(ch2 == '.' || ch2 == ch1){
                    table[i][j] = table[i-1][j-1];
                }else if(ch2 == '*'){
                    if(j>1){
                        if(table[i][j-2])
                            table[i][j] = true;
                        else {
                            char pre = p.charAt(j-2);
                            if(pre == ch1 || pre == '.'){
                                table[i][j] = table[i-1][j];
                            }
//                            else table[i][j] =false;
                        }
                    }
                }


            }
        }
        boolean lastRow[] = table[table.length-1];
        return lastRow[lastRow.length-1];
    }

    public static void main(String[] args){
        Solution0010 solution = new Solution0010();
//        System.out.println(solution.isMatch("ab",".*"));
//        System.out.println(solution.isMatch("aab","c*a*b"));
        System.out.println(solution.isMatch("mississippi","mis*is*p*."));

    }
}