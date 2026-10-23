class Solution {
    public int countVowelSubstrings(String word) {
        int len = 0;
        int n = word.length();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i<n-4; i++){
            set.clear();
            for(int j = i; j<n; j++){
                char c = word.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    set.add(c);
                    if(set.size() == 5) len++;
                }else break;
            }
        }
        return len;
    }
}