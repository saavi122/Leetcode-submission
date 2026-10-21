class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charscnt = new int[26];
        for(char c : chars.toCharArray()){
            charscnt[c-'a']++;
        }
        int tlen = 0;
        for(String w : words){
            int[] wcnt = new int[26];
            for(char c : w.toCharArray()){
                wcnt[c-'a']++;
            }
            boolean canform = true;
            for(int i = 0; i<26; i++){
                if(wcnt[i] > charscnt[i]){ 
                    canform = false; 
                    break;
                }
            }
            if(canform){
                tlen += w.length();
            }
        }
        return tlen;
    }
}