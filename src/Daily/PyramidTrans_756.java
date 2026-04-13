package Daily;

import java.util.*;

public class PyramidTrans_756 {
    HashMap<String, List<Character>> map;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new HashMap<>();

        for (String str : allowed) {
            String key = str.substring(0, 2);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str.charAt(2));
        }

        return check(bottom);
    }

    private boolean check(String bottom) {
        if (bottom.length() == 1) return true;

        List<String> nextLevels = new ArrayList<>();

        constructNextLevel(bottom, nextLevels, new StringBuilder(), 0);

        for (String s : nextLevels) {
            if (check(s)) return true;
        }

        return false;
    }

    private void constructNextLevel(String bottom, List<String> ans, StringBuilder curr, int idx) {
        if (idx == bottom.length() - 1) {
            ans.add(curr.toString());

            return;
        }

        String key = bottom.substring(idx, idx + 2);

        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            curr.append(c);
            constructNextLevel(bottom, ans, curr, idx + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
