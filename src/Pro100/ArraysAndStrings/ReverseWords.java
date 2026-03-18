package Pro100.ArraysAndStrings;

public class ReverseWords {

    char[] s;
    public void reverseWords(char[] s) {
        this.s = s;

        reverse(0, s.length - 1);

        int slow = 0, fast = 0;

        while(fast < s.length){
            if(s[fast] == ' '){
                reverse(slow, fast - 1);
                slow = fast + 1;
            }
            fast ++;
        }

        reverse(slow, fast);
    }

    private void reverse(int start, int end){
        while(start <= end){
            swap(start, end);

            start ++;
            end --;
        }
    }

    private void swap(int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
