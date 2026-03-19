package Pro100.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strings){
            String stand = standardize(s);

            if(map.containsKey(stand)){
                map.get(stand).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);

                map.put(stand, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String standardize(String s){
        int bias = 'z' - s.charAt(0) + 1;

        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (char)((arr[i] - 'a' + bias) % 26 + 'a');
        }

        return new String(arr);
    }

    private boolean checkSimilar(String s, String t){
        if(s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        for(int i = 0; i < s.length() - 1; i ++){
            if(arr1[i + 1] - arr1[i] != arr2[i + 1] - arr2[i]) return false;
        }

        return true;
    }
}
