class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int n = words.length;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            char firstChar = s.charAt(0);
            char lastChar = s.charAt(s.length() - 1);
            if(isvol(firstChar) && isvol(lastChar)){
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isvol(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}