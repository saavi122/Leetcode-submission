class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            N = -N;
            return 1.0/pow(x, N);
        }
        return pow(x,N);
    }

    public double pow(double x, long n){
        if(n == 0) return 1.0;
        double half = pow(x,n/2);
        if(n%2 == 0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
}

// java.lang.NumberFormatException: Infinite or NaN
//   at line 1008, java.base/java.math.BigDecimal.<init>
//   at line 987, java.base/java.math.BigDecimal.<init>
// 	at __Serializer__.serialize(Unknown Source)
//   at line 94, __Driver__.main