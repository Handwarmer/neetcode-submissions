class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> edges = new HashMap<>();
        for (String word : wordList) {
            char[] cs = word.toCharArray();
            for (int i = 0; i < cs.length; i ++) {
                char tmp = cs[i];
                cs[i] = '*';
                String pattern = new String(cs);
                edges.computeIfAbsent(pattern, k -> new HashSet<>()).add(word);
                cs[i] = tmp;
            }
        }
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord); visited.add(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s ++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return steps;
                char[] cs = cur.toCharArray();
                for (int i = 0; i < cs.length; i ++) {
                    char tmp = cs[i];
                    cs[i] = '*';
                    String pattern = new String(cs);
                    for (String nei : edges.getOrDefault(pattern, new HashSet<>())) {
                        if (!visited.add(nei)) continue;
                        q.add(nei);
                    }
                    cs[i] = tmp;
                }
            }
            steps ++;
        }
        return 0;
    }
}
