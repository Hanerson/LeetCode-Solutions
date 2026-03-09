package Daily;

import java.util.Arrays;

public class NumSteps_1404 {
    public int numSteps(String s) {
        int count = 0;

        while(!"1".equals(s)){
            if(s.charAt(s.length() - 1) == '1'){
                s = handleAdd(s);
            }else{
                s = s.substring(0, s.length() - 1);
            }
            count ++;
        }

        return count;
    }

    private String handleAdd(String s){
        char[] arr = s.toCharArray();

        int carry = 1, pos = s.length() - 1;

        while(carry == 1 && pos >= 0){
            if(arr[pos] == '1'){
                arr[pos] = '0';
                pos --;
            }else{
                arr[pos] = '1';
                carry = 0;
            }
        }

        return (carry == 1) ? '1' + new String(arr) : new String(arr);
    }
}
