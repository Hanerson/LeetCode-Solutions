package Basic50;

public class RepeatedSubstring_459 {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i < s.length(); i++){
            String sub =  s.substring(0, i);
            if(canBuild(s, sub)) return true;
        }

        return false;
    }

    private boolean canBuild(String tar, String sub){
        int len = tar.length();
        int subLen = sub.length();

        if(len == subLen || len % subLen != 0) return false;

        for(int i = 0; i < len; i += subLen){
            if(!tar.substring(i, i + subLen).equals(sub)) return false;
        }

        return true;
    }
}
