package Daily;

public class CheckOnesSegments_1784 {
    public boolean checkOnesSegment(String s) {
        char[] arr = ('0' + s + '0').toCharArray();
        int count = 0;
        int pos = 1;
        char prev = '0';

        while(pos < arr.length){
            if(arr[pos] == '0' && prev == '1'){
                count ++;

                if(count >= 2) return false;
            }

            prev = arr[pos];
            pos ++;
        }

        return true;
    }


    public static void main(String[] args) {
        CheckOnesSegments_1784 c = new CheckOnesSegments_1784();
        System.out.println(c.checkOnesSegment("1001"));
    }
}
