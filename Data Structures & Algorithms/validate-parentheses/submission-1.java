class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> m = new HashMap<>();
        m.put('}', '{'); m.put(']','['); m.put(')','(');
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(m.get(c))) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}
