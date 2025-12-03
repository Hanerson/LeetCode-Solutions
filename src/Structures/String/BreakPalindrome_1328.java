package Structures.String;

public class BreakPalindrome_1328 {
    public String breakPalindrome(String s){
        int mid = s.length() / 2;
        boolean flag = false;
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(arr[i] != 'a' && i != mid){
                arr[i] = 'a';
                flag = true;
                break;
            }
            if(i == s.length() - 1 && arr[i] == 'a'){
                arr[i] = 'b';
            }
        }
        return flag ? new String(arr) : "";
    }
}
