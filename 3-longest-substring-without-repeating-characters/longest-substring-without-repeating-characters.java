class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> window = new HashSet<>();
        int l = 0;
        int maxlen = 0;
        for(int r = 0; r<n; r++){
            while(window.contains(s.charAt(r))){
                window.remove(s.charAt(l));
                l++;
            }
            window.add(s.charAt(r));
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}