package Structures.String;

public class NumberOfSpecialChars_3120 {
    public int numberOfSpecialChars(String word) {
        int[] lower =  new int[27];
        int[] upper =  new int[27];

        int count = 0;

        for(char c :  word.toCharArray()) {
            if('a' <= c && c <= 'z') {
                lower[c - 'a']++;
            }
            if('A' <= c && c <= 'Z') {
                upper[c - 'A']++;
            }
        }

        for(int i = 0; i < 27; i++) {
            if(lower[i] != 0 && upper[i] != 0) {
                count++;
            }
        }
        return count;
    }
}
