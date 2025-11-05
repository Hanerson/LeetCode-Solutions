package Algorithm;

public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix[0].length,x=0,y=m-1;
        while(true){
            if(matrix[x][y]==target) return true;
            else{
                if(matrix[x][y]<target){
                    x++;
                    if(x>=matrix.length) return false;
                }
                else{
                    y--;
                    if(y<0) return false;
                }
            }
        }
    }
    public static void main(String[] args){
        SearchMatrix2 s = new SearchMatrix2();
        int[][] ans = new int[][]{
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        };
        System.out.println(s.searchMatrix(ans, 20));
    }
}
