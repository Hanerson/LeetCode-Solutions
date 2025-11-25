package Daily;

import java.util.HashSet;

public class SmallestRepunitDivByK_1015 {
    public int smallestRepunitDivByK(int num){

        if(num % 2 == 0 || num % 5 == 0) return -1;

        HashSet<Integer> set = new HashSet<>();
        int curr = 1, len = 1;
        while(true){
            if(curr % num == 0) return len;
            else{
                curr = curr % num;
                len ++;
                if(set.contains(curr)){
                    return -1;
                }else set.add(curr % num);
                curr = curr * 10 + 1;
            }
        }
    }
}
