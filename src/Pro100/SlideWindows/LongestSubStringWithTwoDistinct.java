package Pro100.SlideWindows;

import java.util.HashMap;

public class LongestSubStringWithTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) return s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        int slow = 0;
        int maxLen = 0;

        for(int fast = 0; fast < s.length(); fast++){
            char c = s.charAt(fast);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.size() > 2){
                char left = s.charAt(slow);
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0){
                    map.remove(left);
                }
                slow++;
            }

            maxLen = Math.max(maxLen, fast - slow + 1);
        }

        return maxLen;
    }
}
