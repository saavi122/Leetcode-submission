class Solution {
    public void reverseString(char[] s) {
        rev(s);
    }

    public char[] rev(char[] s){
        int l = s.length;
        for(int i = 0; i<l/2; i++){
            char temp = s[i];
            s[i] = s[l-1-i];
            s[l-1-i] = temp;
        }
        return s;
    }
}