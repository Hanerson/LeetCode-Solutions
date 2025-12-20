package Daily;

public class MinDeleteCount_944 {
    public int minDeletionSize(String[] strs) {
        int strSize = strs[0].length();
        int countOfStr = strs.length;

        int deletion = 0;

        if(countOfStr > 26) return countOfStr;
        if(countOfStr == 1) return 0;

        for(int pos = 0; pos < strSize; pos++){
            for(int i = 1; i < countOfStr; i++){
                if(strs[i].charAt(pos) <= strs[i - 1].charAt(pos)){
                    deletion++;
                    break;
                }
            }
        }

        return deletion;
    }

    public static void main(String[] args) {
        String[] strs = {"rrjk","furt","guzm"};

        System.out.println(new MinDeleteCount_944().minDeletionSize(strs));

    }
}