class TimeMap {
    Map<String, List<String>> values = new HashMap<>();
    Map<String, List<Integer>> times = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!values.containsKey(key)) {
            List<String> vl = new ArrayList<>();
            List<Integer> tl = new ArrayList<>();
            values.put(key, vl);
            times.put(key, tl);
        }
        values.get(key).add(value);
        times.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        List<String> vl = values.get(key);
        List<Integer> tl = times.get(key);
        if (vl == null) return "";
        int l = 0, r = vl.size() - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (tl.get(m) > timestamp) {
                r = m - 1;
            } else {
                ans = m;
                l = m + 1;
            }
        }
        return ans == -1 ? "" : vl.get(ans);
    }
}
