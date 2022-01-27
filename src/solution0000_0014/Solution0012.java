package solution0000_0014;

public class Solution0012 {

    //12. 整数转罗马数字
    public String stageRomanNum(int stage_num, char big, char middle, char small){
        StringBuilder str = new StringBuilder();
        switch (stage_num){
            case 9:
//                System.out.print(""+small+big);
                str.append(small).append(big);
                break;
            case 8:
//                System.out.print(""+middle+small+small+small);
                str.append(middle).append(small).append(small).append(small);
                break;
            case 7:
//                System.out.print(""+middle+small+small);
                str.append(middle).append(small).append(small);
                break;
            case 6:
//                System.out.print(""+middle+small);
                str.append(middle).append(small);
                break;
            case 5:
//                System.out.print(""+middle);
                str.append(middle);
                break;
            case 4:
//                System.out.print(""+small+middle);
                str.append(small).append(middle);
                break;
            case 3:
//                System.out.print(""+small+small+small);
                str.append(small).append(small).append(small);
                break;
            case 2:
//                System.out.print(""+small+small);
                str.append(small).append(small);
                break;
            case 1:
//                System.out.print(""+small);
                str.append(small);
                break;
        }
        return str.toString();
    }

    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();

        int temp = 0;
        temp = num/1000;
        for(int i=0; i<temp; i++){
//            System.out.print('M');
            str.append("M");
        }

        num = num%1000;
        temp = num/100;
        str.append(stageRomanNum(temp,'M','D','C'));

        num = num%100;
        temp = num/10;
        str.append(stageRomanNum(temp,'C','L','X'));

        num = num%10;
        temp = num;
        str.append(stageRomanNum(temp,'X','V','I'));

        return str.toString();
    }

    public static void main(String[] args){
        Solution0012 solution = new Solution0012();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }
}