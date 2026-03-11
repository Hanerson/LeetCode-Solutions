package Daily;

public class BitwiseComplement_1009 {
    public int bitwiseComplement(int n) {
        int power = 1;
        while(Math.pow(2, power) < n){
            power ++;
        }

        return (int)(Math.pow(2, power) - n + 1);
    }
}
