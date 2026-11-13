class Solution {
    public String removeDigit(String number, char digit) {
        int remidx = -1;
        for(int i = 0; i<number.length(); i++){
            if(number.charAt(i) == digit){
                remidx = i;

                if(i+1 < number.length() && number.charAt(i+1) > digit){
                    break;
                }
            }
        }
        StringBuffer sb = new StringBuffer(number.length() - 1);
        sb.append(number.substring(0, remidx));
        sb.append(number.substring(remidx + 1));
        
        return sb.toString();
    }
}