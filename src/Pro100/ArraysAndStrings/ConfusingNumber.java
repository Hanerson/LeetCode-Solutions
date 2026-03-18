package Pro100.ArraysAndStrings;

import java.util.*;

public class ConfusingNumber {
    public boolean confusingNumber(int n) {
        Map<Character, Character> invertMap = new HashMap<>() {{
            put('0', '0'); put('1', '1'); put('6', '9'); put('8', '8'); put('9', '6');
        }};
        StringBuilder rotated = new StringBuilder();

        for (char ch : String.valueOf(n).toCharArray()) {
            if (!invertMap.containsKey(ch)) {
                return false;  // 出现非法数字
            }
            rotated.append(invertMap.get(ch));
        }

        rotated.reverse();
        return Integer.parseInt(rotated.toString()) != n;
    }
}
