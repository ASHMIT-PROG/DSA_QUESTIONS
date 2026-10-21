class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        long power = n;

        if (power < 0) {
            power = -power;
        }

        for (long i = 0; i < power; i++) {
            result = result * x;
        }

        if (n < 0) {
            result = 1.0 / result;
        }

        return result;
    }
}