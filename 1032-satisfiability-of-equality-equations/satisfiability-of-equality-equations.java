class Solution {
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        int[] par = new int[26];
        for(int i = 0; i<26; i++){
            par[i] = i;
        }
        for(String s : equations){
            if(s.charAt(1) == '='){
                int parx = find(s.charAt(0)-'a',par);
                int pary = find(s.charAt(3)-'a',par);
                if(parx != pary) par[parx] = pary;
            }
        }
        for(String s : equations){
            if (s.charAt(1) == '!'){
                int parx = find(s.charAt(0) - 'a', par);
                int pary = find(s.charAt(3) - 'a', par);
                if (parx == pary) return false;
            }
        }
        return true;
    }
    public int find(int i, int[] par){
        if(par[i] == i) return i;
        return par[i] = find(par[i],par);
    }
}