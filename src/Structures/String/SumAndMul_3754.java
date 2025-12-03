package Structures.String;

public class SumAndMul_3754 {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        char[] num = String.valueOf(n).toCharArray();
        int sum = 0;

        for(char c : num) {
            if(c != '0'){
                sb.append(c);
                sum += c - '0';
            }
        }

        return (sb.length() != 0) ? (long) sum * Integer.parseInt(sb.toString()) : 0;
    }
}
