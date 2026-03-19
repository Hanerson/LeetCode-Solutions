package Pro100.SlideWindows;

import java.util.HashMap;

public class NumKLenSubstring {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > 26)
            return 0;
        int answer = 0;
        int n = s.length();
        int left = 0, right = 0;
        int freq[] = new int[26];

        while (right < n) {
            freq[s.charAt(right) - 'a']++;
            while (freq[s.charAt(right) - 'a'] > 1) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == k) {
                answer++;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return answer;
    }
}
