package Daily;

public class BestClosingTime_2483{
    public int bestClosingTime(String customers) {
        int[] prefix = new  int[customers.length() + 1];
        int[] suffix = new  int[customers.length() + 1];

        char[] arr = customers.toCharArray();

        prefix[0] = 0;
        for(int i = 1; i <= customers.length(); i++){
            prefix[i] = prefix[i - 1] + (arr[i - 1] == 'N' ? 1 : 0);
        }

        suffix[customers.length()] = 0;
        for(int i = customers.length() - 1; i >= 0; i--){
            suffix[i] = suffix[i + 1] + (arr[i] == 'Y' ? 1 : 0);
        }

        int ans = 0;
        int cost = Integer.MAX_VALUE;

        for(int i = 0; i <= customers.length(); i++){
            int temp = prefix[i] + suffix[i];

            if (temp < cost) {
                ans = i;
                cost = temp;
            }
        }

        if(suffix[0] < cost){
            return 0;
        }

        return ans;
    }

    public int bestTime(String customers){
        char[] arr = customers.toCharArray();

        int count = 0;

        for(char c : arr){
            count += c == 'Y' ? 1 : 0;
        }

        int ans = 0, cost = Integer.MAX_VALUE, currCost = 0, countOfCustomers = 0;
        for(int i = 0; i <= customers.length(); i++){
            currCost = i - customers.length() + (count - countOfCustomers);

            if(currCost < cost){
                ans = i;
            }

            countOfCustomers += arr[i] == 'Y' ? 1 : 0;
        }

        return ans;
    }
}