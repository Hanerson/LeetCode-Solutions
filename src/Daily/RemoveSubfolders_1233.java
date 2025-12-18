package Daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveSubfolders_1233 {
    public List<String> removeSubfolders(String[] folder) {
        HashSet<String> superFolders = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for(String path : folder){
            String[] tokens = path.split("/");

            if(!superFolders.contains(tokens[1])){
                superFolders.add(tokens[1]);
                ans.add(path);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RemoveSubfolders_1233 r = new RemoveSubfolders_1233();
        System.out.println(r.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }

}
