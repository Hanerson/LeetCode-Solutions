package Daily;

import java.util.HashMap;

public class LongestBalanced_3714_bruteForce {
    public int longestBalanced(String s) {
        int maxLen = 0;

        for(int i = 0; i < s.length(); i ++){
            for(int j = i + 1; j <= s.length(); j ++){
                String sub = s.substring(i, j);

                if(check(sub)) maxLen = Math.max(maxLen, sub.length());
            }
        }

        return maxLen;
    }

    private boolean check(String s){
        if(s.length() == 0) return true;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int comp = map.get(s.charAt(0));

        for(int num : map.values()){
            if(num != comp) return false;
        }

        return true;
    }
}
