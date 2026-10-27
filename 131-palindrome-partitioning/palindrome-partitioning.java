class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s,0,new ArrayList<>(),res);
        return res;
    }
    public boolean isPalin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public void helper(String s, int i, List<String> ans, List<List<String>> res){
        if(i == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int j = i+1; j<=s.length(); j++){
            if(isPalin(s,i,j-1)){
                ans.add(s.substring(i,j));
                helper(s,j,ans,res);
                ans.remove(ans.size()-1);
            }
        }
    }
}