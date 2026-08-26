class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append('#').append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int idx = str.indexOf('#');
        List<String> res = new ArrayList<>();
        if (idx == -1) return res;
        while (idx < str.length()) {
            int idx2 = str.indexOf('#', idx+1);
            int len = Integer.valueOf(str.substring(idx+1, idx2));
            String s = str.substring(idx2+1, idx2+1+len);
            res.add(s);
            idx = idx2+len+1;
        }
        return res;
    }
}
