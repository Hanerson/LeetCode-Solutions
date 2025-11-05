import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int fast = 10, slow = 0;
        while(fast <= s.length()){
            String cur = s.substring(slow, fast);
            if(set.contains(cur) && !res.contains(cur)){
                res.add(cur);
            }else{
                set.add(cur);
            }
            fast++;
            slow++;
        }

        return res;
    }
}