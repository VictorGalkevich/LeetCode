class Problem1411 {
    public static void main(String[] args) {
        System.out.println(numOfWays(6));
    }
    public static int numOfWays(int n) {
        long distinct = 6;
        long nonDistinct = 6;
        long mod = 1000000007;

        for(int i = 1 ; i < n ; i++){
            long newDistinct = (distinct * 2 + nonDistinct * 2) % mod;
            long newNonDistinct = (distinct * 2 + nonDistinct * 3) % mod;

            distinct = newDistinct;
            nonDistinct = newNonDistinct;
        }

        return (int) ((distinct + nonDistinct) % mod);
    }
}