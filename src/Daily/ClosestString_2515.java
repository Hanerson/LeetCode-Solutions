package Daily;

public class ClosestString_2515 {
    public int closestTarget(String[] words, String target, int startIndex) {
        boolean contain = false;

        for(String word : words){
            if(word.equals(target)){
                contain = true;
                break;
            }
        }

        if(!contain) return -1;

        if(words[startIndex].equals(target)) return 0;

        int left = 1, right = 1;

        int CLeft = (startIndex + 1) % words.length;
        int CRight = (startIndex - 1 + words.length) % words.length;

        while(!words[CLeft].equals(target)){
            CLeft = (CLeft + 1) % words.length;

            left ++;
        }

        while(!words[CRight].equals(target)){
            CRight = (CRight - 1 + words.length) % words.length;

            right ++;
        }

        return Math.min(right, left);
    }
}
