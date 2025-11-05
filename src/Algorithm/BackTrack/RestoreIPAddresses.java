package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        helper(res, 0, s, 4, new ArrayList<>());
        return res;
    }

    private void helper(List<String> res, int depth, String s, int left, List<String> curr) {
        if (s.length() - depth < left || s.length() - depth > left * 3) return;
        if (left == 0 && depth == s.length()) {
            res.add(String.join(".", curr));
            return;
        }
        for (int len = 1; len <= 3 && depth + len <= s.length(); len++) {
            String part = s.substring(depth, depth + len);

            if (part.length() > 1 && part.charAt(0) == '0') break;

            int num = Integer.parseInt(part);
            if (num > 255) break;

            curr.add(part);
            helper(res, depth + len, s, left - 1, curr);
            curr.remove(curr.size() - 1);
        }
    }


    public static void main(String[] args) {
        RestoreIPAddresses r = new RestoreIPAddresses();
        List<String> res = r.restoreIpAddresses("101023");
        System.out.println(res);
    }
}
