class Solution {
    public double myPow(double x, int n) {
        long N = Math.abs((long) n);

        double ans = 1.0;

        for (long i = 0; i < N; i++) {
            ans *= x;
        }

        if (n < 0) {
            return 1.0 / ans;
        } else {
            return ans;
        }
    }
}