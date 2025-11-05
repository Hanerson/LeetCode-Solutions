package Structures.String;

import java.util.*;

public class FindLadders {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // always expand the smaller side
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            HashSet<String> nextLevel = new HashSet<>();

            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String next = new String(chars);
                        if (endSet.contains(next)) {
                            return step + 1;
                        }
                        if (wordSet.contains(next) && !visited.contains(next)) {
                            nextLevel.add(next);
                            visited.add(next);
                        }
                    }
                    chars[i] = old;
                }
            }

            beginSet = nextLevel;
            step++;
        }

        return 0;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) return res;

        HashMap<String, List<String>> neighbours = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, wordSet, neighbours, distance);
        dfs(beginWord, endWord, neighbours, distance, new ArrayList<>(), res);

        return res;
    }

    private void bfs(String beginWord, String endWord, HashSet<String> wordList,
                     HashMap<String, List<String>> neighbours, HashMap<String, Integer> distance) {
        for (String word : wordList) neighbours.put(word, new ArrayList<>());
        neighbours.put(beginWord, new ArrayList<>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        boolean foundEnd = false;

        while (!queue.isEmpty() && !foundEnd) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                List<String> nextWords = generateNeighbours(curr, wordList);
                for (String next : nextWords) {
                    neighbours.get(curr).add(next);
                    if (!distance.containsKey(next)) {
                        distance.put(next, distance.get(curr) + 1);
                        if (next.equals(endWord)) foundEnd = true;
                        queue.offer(next);
                    }
                }
            }
        }
    }

    private void dfs(String curr, String target,
                     HashMap<String, List<String>> neighbours,
                     HashMap<String, Integer> distance,
                     List<String> path,
                     List<List<String>> res) {
        path.add(curr);
        if (curr.equals(target)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String next : neighbours.getOrDefault(curr, new ArrayList<>())) {
                if (distance.getOrDefault(next, Integer.MAX_VALUE) == distance.get(curr) + 1) {
                    dfs(next, target, neighbours, distance, path, res);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private List<String> generateNeighbours(String curr, HashSet<String> wordList) {
        List<String> res = new ArrayList<>();
        char[] arr = curr.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char origin = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == origin) continue;
                arr[i] = c;
                String next = new String(arr);
                if (wordList.contains(next)) res.add(next);
            }
            arr[i] = origin;
        }
        return res;
    }


}
