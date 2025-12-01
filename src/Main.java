import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opNums = sc.nextInt(), range = sc.nextInt();

        int[] parents =  new int[range + 1];

        Arrays.fill(parents, -1);

        for(int k = 0; k < opNums; k++){
            int syn = sc.nextInt();
            int oprA =  sc.nextInt();
            int oprB =  sc.nextInt();

            switch(syn){
                case 1:
                    union(parents, oprA, oprB);
                    break;
                case 2:
                    System.out.println(find(parents, oprB) == find(parents, oprA) ? 1 : 0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void union(int[] parent, int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if(rootA == rootB) return;

        if (parent[rootA] < parent[rootB]) {
            parent[rootB] = rootA;
        } else {
            if (parent[rootA] == parent[rootB]) {
                parent[rootB]--;
            }
            parent[rootA] = rootB;
        }
    }

    private static int find(int[] parents, int opr){
        if(parents[opr] < 0) return opr;
        return parents[opr] = find(parents ,parents[opr]);
    }
}