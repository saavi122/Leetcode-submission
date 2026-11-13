class Solution {
    public int secondHighest(String s) {
        int lar = -1;
        int seclar = -1;

        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                int num = c-'0';
                if(num > lar){
                    seclar = lar;
                    lar = num;
                }else if(num < lar && num > seclar){
                    seclar = num;
                }
            }
        }
        return seclar;
    }
}