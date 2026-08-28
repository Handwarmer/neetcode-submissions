class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();
        int a, b;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    a = Integer.valueOf(s.pop()); b = Integer.valueOf(s.pop());
                    s.push(b + a); break;
                case "-":
                    a = Integer.valueOf(s.pop()); b = Integer.valueOf(s.pop());
                    s.push(b - a); break;
                case "*":
                    a = Integer.valueOf(s.pop()); b = Integer.valueOf(s.pop());
                    s.push(b * a); break;
                case "/":
                    a = Integer.valueOf(s.pop()); b = Integer.valueOf(s.pop());
                    s.push(b / a); break;
                default:
                    s.push(Integer.valueOf(t));
            }
        }
        return s.pop();
    }
}
