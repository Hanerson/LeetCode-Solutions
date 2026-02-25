class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int num = left; num <= right; num++){
            count += (isPrime(countBits(num))) ? 1 : 0;
        }

        return count;
    }

    public int countBits(int num){
        int count = 0;

        while(num != 0){
            count += num % 2;
            num /= 2;
        }

        return count;
    }

    public boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2) return true;
        if(num == 3) return true;

        for(int i = 2; i * i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}