class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> inedges = new HashMap<>();
        Map<Character, Set<Character>> outedges = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                inedges.putIfAbsent(c, new HashSet<>());
                outedges.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i ++) {
            char[] cur = words[i].toCharArray(), prev = words[i-1].toCharArray();
            boolean found = false;
            for (int j = 0; j < Math.min(cur.length, prev.length); j ++) {
                if (cur[j] != prev[j]) {
                    inedges.get(cur[j]).add(prev[j]);
                    outedges.get(prev[j]).add(cur[j]);
                    found = true;
                    break;
                }
            }
            // 处理prefix非法的情况
            if (!found && cur.length < prev.length) return "";
        }
        Deque<Character> q = new ArrayDeque<>();

        for (Map.Entry<Character, Set<Character>> e : inedges.entrySet()) {
            if (e.getValue().isEmpty()) q.add(e.getKey());
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.poll();
            ans.append(cur);
            for (Character next : outedges.get(cur)) {
                inedges.get(next).remove(cur);
                if (inedges.get(next).isEmpty()) q.add(next);
            }
        }
        return ans.length() == inedges.size() ? ans.toString() : "";
    }
}
