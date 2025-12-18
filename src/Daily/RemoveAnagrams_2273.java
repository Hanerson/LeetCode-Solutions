package Daily;

import java.util.ArrayList;
import java.util.List;

public class RemoveAnagrams_2273 {

    private static final int[] PRIMES = new int[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101
    };


    public List<String> removeAnagrams(String[] words){
        List<String> ans = new ArrayList<>();

        String origin = words[0];
        int comp = SYN(origin);
        ans.add(origin);

        for(int i = 1; i < words.length; i++){
            if(SYN(words[i]) != comp){
                comp =  SYN(words[i]);
                ans.add(words[i]);
            }
        }

        return ans;
    }

    private int SYN(String word){
        int muti = 1;

        for(char c : word.toCharArray()){
            muti *= PRIMES[c - 'a'];
        }

        return muti;
    }


    public static void main(String[] args) {
        RemoveAnagrams_2273 obj = new RemoveAnagrams_2273();

        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(obj.removeAnagrams(words));
    }
}
