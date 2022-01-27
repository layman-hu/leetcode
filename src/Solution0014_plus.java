
public class Solution0014_plus {

    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null)return "";
        if(strs.length == 1)return strs[0];

        String prefix = strs[0];
        StringBuffer temp = new StringBuffer();
        for(String s: strs){
            while (!s.startsWith(prefix.toString())){
                //公共前缀不匹配就让它变短！
                if(prefix.length()==0)return "";
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args){
        Solution0014_plus solution = new Solution0014_plus();
//        String []strs = {"flower","flow","flight"};
//        String []strs = {"dog","racecar","car"};
        String []strs = {"1212","1212","12"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}