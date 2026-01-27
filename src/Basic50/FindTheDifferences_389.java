package Basic50;

public class FindTheDifferences_389 {
    public char findTheDifference(String s, String t) {
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            dict[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < dict.length; i++){
            if(dict[i] % 2 == 1){
                return (char)(i + 'a');
            }
        }
        return 0;
    }
}
