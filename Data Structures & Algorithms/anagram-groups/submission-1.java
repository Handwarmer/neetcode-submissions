class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            String countChar = countChars(str);
            m.putIfAbsent(countChar, new ArrayList<String>());
            m.get(countChar).add(str);
        }
        return new ArrayList<>(m.values());
    }
    
    private String countChars(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c-'a'] ++;
        }
        return Arrays.toString(count);
    }
}
