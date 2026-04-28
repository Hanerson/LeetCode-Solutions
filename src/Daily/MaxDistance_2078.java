package Daily;

public class MaxDistance_2078 {
    public int maxDistance(int[] colors) {
        int maxDis = colors.length - 1;

        boolean passed = false;

        while(!passed){
            for(int i = 0; i + maxDis < colors.length; i ++){
                if(colors[i] != colors[i + maxDis]){
                    passed = true;
                }
            }

            if(!passed) maxDis --;
        }

        return maxDis;
    }
}
