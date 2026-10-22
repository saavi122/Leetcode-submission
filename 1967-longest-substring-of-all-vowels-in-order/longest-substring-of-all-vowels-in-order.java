class Solution {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        int cnt = 1;
        int len = 1;
        int maxlen = 0;
        for(int i = 1; i<n; i++){
            if(word.charAt(i) == word.charAt(i-1)) len++;
            else if(word.charAt(i-1) < word.charAt(i)){
                cnt++;
                len++;
            }else{
                len = 1;
                cnt = 1;
            }
            if(cnt == 5){
                maxlen = Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
}