public class Mathtool {
    public int factorialRecursive(int n) {
        if (n == 0) return 1;
        return n * factorialRecursive(n-1);
    }

    public long factorialIterative(int n){
        long result=1;
        for (int i=1; i<=n; i++){
            result *= i;
        }
        return result;
    }
}
