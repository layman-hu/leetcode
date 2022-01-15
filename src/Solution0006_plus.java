

public class Solution0006_plus {

    //6. Z 字形变换
    public static String convert(String s, int numRows) {
        //numRows行对应numRows个StringBuild
        if(numRows == 1) return s;
        StringBuilder[] strs = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) strs[i] = new StringBuilder();

        int index = 0;
        int sign = 1;
        for(char c:s.toCharArray()){
            strs[index].append(c);
            index += sign;
            if(index==0 || index==numRows-1){
                sign = -sign;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i<numRows; i++){
            result.append(strs[i]);
        }

        return result.toString();
    }

    public static void main(String[] args){
        System.out.print(convert("PAYPALISHIRING", 3));
    }
}