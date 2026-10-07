class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            if(set.contains(n)) return false;
            set.add(n);
            int sum = 0;
            int temp = n;
            while(temp > 0){
                int digit = temp % 10;
                sum += pow(digit, 2);
                temp /= 10;
            }
            n = sum;
        }
    return true;
    }

    public long pow(int b, int exp){
        long res = 1;
        for(int i = 0; i < exp; i++) res *= b;
        return res;
    }

}