public class Solution0013 {

    //13. 罗马数字转整数
    public int romanToInt(String s) {
        String roman_strs[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int roman_nums[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int result = 0;
        StringBuffer str = new StringBuffer(s);

        for(int i=0; i<13; i++){
            while (str.length() != 0 && str.substring(0,1).equals(roman_strs[i])){
                result += roman_nums[i];
                StringBuffer temp = new StringBuffer(str.substring(1));
                str.delete(0,str.length());
                str.append(temp);
            }
            while (str.length() > 1 && str.substring(0,2).equals(roman_strs[i])){
                result += roman_nums[i];
                StringBuffer temp = new StringBuffer(str.substring(2));
                str.delete(0,str.length());
                str.append(temp);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution0013 solution = new Solution0013();
//        System.out.println(solution.romanToInt("III"));
//        System.out.println(solution.romanToInt("IV"));
//        System.out.println(solution.romanToInt("IX"));
//        System.out.println(solution.romanToInt("LVIII"));
//        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println(solution.romanToInt("XLIV"));
    }
}