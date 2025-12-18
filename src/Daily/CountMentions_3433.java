package Daily;

import java.util.*;

public class CountMentions_3433 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] freq = new int[numberOfUsers];

        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 != t2) return t1 - t2;

            String type1 = a.get(0);
            String type2 = b.get(0);

            if (type1.equals("OFFLINE") && type2.equals("MESSAGE")) return -1;
            if (type1.equals("MESSAGE") && type2.equals("OFFLINE")) return 1;

            return 0;
        });


        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numberOfUsers; i++) map.put(i, 0);

        for(List<String> event : events){
            String EVENT_TYPE = event.get(0);
            String TICKET = event.get(1);
            String USER = event.get(2);

            if(EVENT_TYPE.equals("MESSAGE")){
                switch(USER){
                    case "ALL":
                        for(int i = 0; i < numberOfUsers; i++){
                            freq[i] ++;
                        }
                        break;
                    case "HERE":
                        for(int i = 0; i < numberOfUsers; i++){
                            if(map.get(i) <= Integer.parseInt(TICKET)){
                                freq[i] ++;
                            }
                        }
                        break;
                    default:
                        String[] users = USER.split(" ");
                        for(String user : users){
                            int len =  user.length() - 2;
                            char[] userChars = user.toCharArray();
                            char[] id_str = new char[len];
                            System.arraycopy(userChars, 2, id_str, 0, len);
                            int id = Integer.parseInt(String.valueOf(id_str));

                            freq[id]++;
                        }
                        break;
                }
            }else{
                map.put(Integer.parseInt(USER), Integer.parseInt(TICKET) + 60);
            }
        }
        return freq;
    }
}
