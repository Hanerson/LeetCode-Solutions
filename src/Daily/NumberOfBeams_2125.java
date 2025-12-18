package Daily;

import java.util.ArrayList;
import java.util.List;

public class NumberOfBeams_2125 {
    public int numberOfBeams(String[] strings){
        int len =  strings.length;
        List<Integer> list = new ArrayList<>();

        for(String s: strings){
            if(count(s) != 0) list.add(count(s));
        }

        int ans = 0;

        if(list.isEmpty() || list.size() == 1) return 0;

        int prev = list.get(0);
        for(int i = 1; i < list.size(); i++){
            ans += prev *  list.get(i);
            prev = list.get(i);
        }

        return ans;
    }

    private int count(String bin){
        int count = 0;
        for(char c : bin.toCharArray()){
            count += c - '0';
        }
        return count;
    }
}
