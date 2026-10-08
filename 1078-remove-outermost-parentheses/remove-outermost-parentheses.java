class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length() <= 2) return "";
        StringBuffer sb = new StringBuffer();
        int str = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                str++;
                if(str > 1) sb.append('('); 
            }else{
                if(str > 1) sb.append(')');
                str--;
            }
        }
        return sb.toString();
    }
}