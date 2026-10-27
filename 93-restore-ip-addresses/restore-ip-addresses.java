class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return ans;
        helper(s, 0, 0, ans, new StringBuilder());
        return ans;
    }
    
    public void helper(String s, int idx, int pt, List<String> ans, StringBuilder sb) {
        if (idx == s.length() && pt == 4) {
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }
        if (pt >= 4 || idx == s.length()) return;
        
        for (int len = 1; len <= 3; len++) {
            if (idx + len > s.length()) break;
            String part = s.substring(idx, idx + len);
            if (part.length() > 1 && part.charAt(0) == '0') break;
            int value = Integer.parseInt(part);
            if (value <= 255) {
                int currentLen = sb.length();
                sb.append(part).append(".");
                helper(s, idx + len, pt + 1, ans, sb);
                sb.setLength(currentLen);
            }
        }
    }
}
