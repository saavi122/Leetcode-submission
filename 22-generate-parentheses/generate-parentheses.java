class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,0,0,res,"");
        return res;
    }
    public void helper(int n, int left, int right, List<String> res, String s){
        if(s.length() == n*2){
            res.add(s);
            return;
        }
        if(left < n){
            helper(n, left+1, right, res, s+"(");
        }
        if(right < left){
            helper(n,left, right+1, res, s+")");
        }
    }
}