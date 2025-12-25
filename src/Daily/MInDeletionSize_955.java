package Daily;

public class MInDeletionSize_955 {
    int[] comp;

    public int minDeletionSize(String[] strs) {
        comp = new int[strs[0].length()];

        int strSize = strs[0].length();
        int count = 0;

        for(int i = 0; i < strSize; i++) {
            for(int pos = 1; pos < strs.length; pos ++){
                comp[i] = 1;
                if(!isBigger(strs[pos - 1], strs[pos])){
                    comp[i] = 0;
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    private boolean isBigger(String a, String b){
        StringBuilder aa = new StringBuilder();
        StringBuilder bb = new StringBuilder();

        for(int i = 0; i < a.length(); i++){
            if(comp[i] == 1){
                aa.append(a.charAt(i));
                bb.append(b.charAt(i));
            }
        }

        return aa.toString().compareTo(bb.toString()) <= 0;
    }

    public static void main(String[] args) {
        String[] strs = {"ca","bb","ac"};

        System.out.println(new MInDeletionSize_955().minDeletionSize(strs));
    }
}
