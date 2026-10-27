class Solution {
    String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        helper(digits,0,new StringBuffer(),ans);
        return ans;
    }

    public void helper(String digi, int idx, StringBuffer sb, List<String> ans){
        if(idx == digi.length()){
            ans.add(sb.toString());
            return;
        }
        String w = arr[digi.charAt(idx)-'2'];
        for(char c : w.toCharArray()){
            sb.append(c);
            helper(digi,idx+1,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}