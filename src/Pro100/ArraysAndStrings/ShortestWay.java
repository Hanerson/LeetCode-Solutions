package Pro100.ArraysAndStrings;

import java.util.*;

public class ShortestWay {
    public int shortestWay(String source, String target) {
        if(!preCheck(source, target)) return -1;

        int ans = 1;
        int placedPos = 0;

        char[] arr = target.toCharArray();

        for(int i = 0; i < arr.length; i++){
            char curr = arr[i];

            while(placedPos < source.length() && source.charAt(placedPos) != curr){
                placedPos++;
            }

            if(placedPos == source.length()){
                placedPos = 0;
                ans++;
                i--;
            } else {
                placedPos++;
            }
        }

        return ans;
    }

    private boolean preCheck(String source, String target){
        HashSet<Character> dict = new HashSet<>();

        for(char c : source.toCharArray()){
            dict.add(c);
        }

        for(char c : target.toCharArray()){
            if(!dict.contains(c)) return false;
        }

        return true;
    }
}
