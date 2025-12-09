package Daily;

public class CountCollisions_2211 {
    public int countCollisions(String dir){
        char[] arr = dir.toCharArray();
        int head = 0, tail = arr.length - 1;
        while(head < arr.length && arr[head] == 'L') head ++;
        while(tail >= 0 && arr[tail] == 'R') tail --;

        int count = 0;

        for(int i = head; i <= tail; i++){
            if(arr[i] != 'S') count ++;
        }

        return count;
    }
}
