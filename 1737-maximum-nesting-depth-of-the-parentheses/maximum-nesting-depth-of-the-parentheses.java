class Solution {
    public int maxDepth(String s) {
        int maxdepth = 0;
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
                maxdepth = Math.max(cnt,maxdepth);
            }
            else if(s.charAt(i) == ')'){
                cnt--;
            }
        }
        return maxdepth;
    }
}