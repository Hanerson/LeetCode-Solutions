package Daily;

import java.util.*;

public class TwoEditWords_2452 {

    String[] dict;
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        this.dict = dictionary;

        List<String> ans = new ArrayList<>();


        for(String query : queries){
            if(check(query)) ans.add(query);
        }

        return ans;
    }

    private boolean check(String query){
        for(String target : dict){
            int count = 0;

            for(int i = 0; i < query.length(); i ++){
                if(query.charAt(i) != target.charAt(i)){
                    count ++;

                    if(count > 2) break;
                }
            }

            if(count <= 2){
                return true;
            }
        }

        return false;
    }
}
