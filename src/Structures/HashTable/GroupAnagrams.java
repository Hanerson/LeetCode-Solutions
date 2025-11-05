package Structures.HashTable;

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ans = new HashMap<>();
        for (String str : strs){
            char[] chars =str.toCharArray();
            Arrays.sort(chars);
            String obj = new String(chars);
            if (!ans.containsKey(obj)){
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.put(obj,list);
            }else{
                List<String> list = ans.get(obj);
                list.add(str);
            }
        }
        return new ArrayList<>(ans.values());
    }
    //另外一种小规模数据处理方法“质数表”
    public List<List<String>> groupAnagrams_Table(String[] strs){
        final int[] table = new int[]{
                2,  3,  5,  7,  11, 13, 17, 19, 23,
                29, 31, 37, 41, 43, 47, 53, 59, 61,
                67, 71, 73, 79, 83, 89, 97, 101
        };
        Map<Integer,List<String>> ans = new HashMap<>();
        for (String str:strs){
            int length = str.length();
            int count=1;
            for(int i=0;i<length;i++){
                count *= table[str.charAt(i)-'a'];
            }
            if(!ans.containsKey(count)){
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.put(count,list);
            }else{
                List<String> list = ans.get(count);
                list.add(str);
            }
        }
        return new ArrayList<>(ans.values());
    }



    public static String[] generateTestData(int groupCount, int wordsPerGroup, int wordLength) {
        Random random = new Random();
        List<String> data = new ArrayList<>(groupCount * wordsPerGroup);

        for (int i = 0; i < groupCount; i++) {
            // 随机生成一个基础字符串
            char[] base = new char[wordLength];
            for (int j = 0; j < wordLength; j++) {
                base[j] = (char) ('a' + random.nextInt(26));
            }

            // 生成该组的所有异位词
            for (int k = 0; k < wordsPerGroup; k++) {
                char[] shuffled = base.clone();
                // 打乱字符顺序
                for (int x = wordLength - 1; x > 0; x--) {
                    int y = random.nextInt(x + 1);
                    char temp = shuffled[x];
                    shuffled[x] = shuffled[y];
                    shuffled[y] = temp;
                }
                data.add(new String(shuffled));
            }
        }
        // 打乱整体顺序
        Collections.shuffle(data);

        return data.toArray(new String[0]);
    }

    public static void main(String[] args){
        GroupAnagrams GroupAnagrams = new GroupAnagrams();
        String[] strs = generateTestData(2000, 50, 4);
        System.out.println("生成测试数据总数: " + strs.length);

        // 方法1：排序法
        long start1 = System.nanoTime();
        List<List<String>> result1 = GroupAnagrams.groupAnagrams(strs);
        long end1 = System.nanoTime();
        System.out.println("排序法耗时: " + (end1 - start1) / 1_000_000.0 + " ms");

        // 方法2：质数表法
        long start2 = System.nanoTime();
        List<List<String>> result2 = GroupAnagrams.groupAnagrams_Table(strs);
        long end2 = System.nanoTime();
        System.out.println("质数表法耗时: " + (end2 - start2) / 1_000_000.0 + " ms");
    }
}