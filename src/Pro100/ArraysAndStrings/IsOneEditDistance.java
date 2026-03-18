package Pro100.ArraysAndStrings;

public class IsOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()){
            boolean changed = false;

            for(int i = 0; i < s.length(); i ++){
                if(s.charAt(i) != t.charAt(i)){
                    if(changed) return false;

                    changed = true;
                }
            }

            return changed;
        }

        if(Math.abs(s.length() - t.length()) != 1) return false;

        char[] longer = ((s.length() < t.length()) ? t : s).toCharArray();
        char[] shorter = ((s.length() > t.length()) ? t : s).toCharArray();

        int ptr = 0;
        boolean appended = false;

        for(int i = 0; i < longer.length; i ++){
            if(ptr == shorter.length) return true;
            if(shorter[ptr] != longer[i]){
                if(appended) return false;

                appended = true;
            }else ptr ++;
        }

        return appended;
    }
}
