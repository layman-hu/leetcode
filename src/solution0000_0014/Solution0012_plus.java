package solution0000_0014;

public class Solution0012_plus {

    //12. 整数转罗马数字

    //哈希表映射思路

    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();

        String roman_strs[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int roman_nums[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0; i<13; i++){
            while (num>=roman_nums[i]){
                num -= roman_nums[i];
                str.append(roman_strs[i]);
            }
        }

        return str.toString();
    }

    public static void main(String[] args){
        Solution0012_plus solution = new Solution0012_plus();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }
}