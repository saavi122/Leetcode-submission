class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    public void solve(int[] candi, int idx, int targ, List<Integer> ans, List<List<Integer>> res){
        if(targ == 0){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = idx; i<candi.length; i++){
            if(candi[i]>targ) break;
            if(i > idx && candi[i] == candi[i-1]) continue;

            ans.add(candi[i]);
            solve(candi, i+1, targ - candi[i], ans, res);
            ans.remove(ans.size() - 1);
        }
    }
}