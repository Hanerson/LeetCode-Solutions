package Basic50;

public class MergeString_1768 {
    public String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int pos1 = 0, pos2 = 0;
        StringBuilder sb = new StringBuilder();

        while(pos1 < arr1.length && pos2 < arr2.length){
            sb.append(arr1[pos1]);
            sb.append(arr2[pos2]);

            pos1++;
            pos2++;
        }

        if(pos1 == arr1.length){
            for(int i = pos2; i < arr2.length; i++){
                sb.append(arr2[i]);
            }
        }else{
            for(int i = pos1; i < arr1.length; i++){
                sb.append(arr1[i]);
            }
        }

        return sb.toString();
    }
}
